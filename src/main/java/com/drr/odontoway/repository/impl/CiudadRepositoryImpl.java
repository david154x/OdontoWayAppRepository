package com.drr.odontoway.repository.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.drr.odontoway.core.JpaUtil;
import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.CiudadEntity;
import com.drr.odontoway.repository.CiudadRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class CiudadRepositoryImpl extends GenericRepositoryImpl<CiudadEntity, Integer> implements CiudadRepository {

	public CiudadRepositoryImpl() {
		super(CiudadEntity.class);
	}
	
	@Inject
	private JpaUtil jpaUtil;

	@Override
	public CiudadEntity consultarSiExisteCiudadXPais(Integer idPais, String nombreCiudad) {
	    try {
	        EntityManager em = this.jpaUtil.getEntityManager();

	        StringBuilder stBuild = new StringBuilder();
	        stBuild.append("SELECT c FROM CiudadEntity c \n")
	               .append("WHERE c.paisEntity.idPais = :idPais \n")
	               .append("AND UPPER(c.nombreCiudad) = :nombreCiudad");

	        TypedQuery<CiudadEntity> query = em.createQuery(stBuild.toString(), CiudadEntity.class);
	        query.setParameter("idPais", idPais);
	        query.setParameter("nombreCiudad", nombreCiudad.toUpperCase());

	        return query.getSingleResult();

	    } catch (NoResultException e) {
	        return null;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}


	@Override
	public List<CiudadEntity> consultarCiudadXFiltros(Integer idPais, String nombre, String estado, List<Date> fechas) {
		StringBuilder stBuild = new StringBuilder("SELECT c FROM CiudadEntity c WHERE 1=1");
	    Map<String, Object> parametros = new HashMap<>();
	    
	    if ( idPais != null ) {
	        stBuild.append(" AND c.paisEntity.idPais = :idPais");
	        parametros.put("idPais", idPais);
	    }

	    if ( nombre != null && !nombre.isEmpty()) {
	        stBuild.append(" AND LOWER(c.nombreCiudad) = :nombreCiudad");
	        parametros.put("nombreCiudad", nombre.toLowerCase());
	    }

	    if ( estado!= null && !estado.isEmpty()) {
	        stBuild.append(" AND c.idEstado = :estado");
	        parametros.put("estado", estado);
	    }

	    if ( fechas != null && !fechas.isEmpty() ) {

	        if ( fechas.size() == 2 && fechas.get(0) != null && fechas.get(1) != null ) {
	        	
	            stBuild.append(" AND c.fechaCreacion BETWEEN :fechaInicio AND :fechaFin");
	            parametros.put("fechaInicio", fechas.get(0));
	            parametros.put("fechaFin", fechas.get(1));
	            
	        }
	    }
	    
	    TypedQuery<CiudadEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), CiudadEntity.class);
	    parametros.forEach(query::setParameter);
	    return query.getResultList();
	}

	@Override
	public List<CiudadEntity> consultarCiudadesXPais(Integer idPais) {
	    try {
	        EntityManager em = this.jpaUtil.getEntityManager();

	        StringBuilder stBuild = new StringBuilder();
	        stBuild.append("SELECT c FROM CiudadEntity c \n")
	               .append("WHERE c.paisEntity.idPais = :idPais");

	        TypedQuery<CiudadEntity> query = em.createQuery(stBuild.toString(), CiudadEntity.class);
	        query.setParameter("idPais", idPais);

	        List<CiudadEntity> lstCiudadesEncontradas = query.getResultList();
	        
	        if ( lstCiudadesEncontradas != null && !lstCiudadesEncontradas.isEmpty() )
	        	return lstCiudadesEncontradas;

	    } catch (Exception e) {
	        e.getMessage();
	    }
	    return null;
	}

}
