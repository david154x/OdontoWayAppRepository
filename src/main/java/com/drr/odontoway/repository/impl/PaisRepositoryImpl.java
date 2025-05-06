package com.drr.odontoway.repository.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.drr.odontoway.core.JpaUtil;
import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.PaisEntity;
import com.drr.odontoway.repository.PaisRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class PaisRepositoryImpl extends GenericRepositoryImpl<PaisEntity, Integer> implements PaisRepository {

	public PaisRepositoryImpl() {
		super(PaisEntity.class);
	}
	
	@Inject
	private JpaUtil jpaUtil;

	@Override
	public PaisEntity consultarPaisXNombre(String nombrePais) {
		try {
			StringBuilder stBuild = new StringBuilder();
			stBuild.append("SELECT p FROM PaisEntity p \n")
				   .append("WHERE \n")
				   .append("p.nombrePais = :nombrePais \n");
			
			TypedQuery<PaisEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), PaisEntity.class);
			
			query.setParameter("nombrePais", nombrePais);
			
			return query.getSingleResult();
			
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public PaisEntity consultarPaisXNombreCorto(String nombreCorto) {
		try {
			StringBuilder stBuild = new StringBuilder();
			stBuild.append("SELECT p FROM PaisEntity p \n")
				   .append("WHERE \n")
				   .append("p.nombreCorto = :nombreCorto \n");
			
			TypedQuery<PaisEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), PaisEntity.class);
			
			query.setParameter("nombreCorto", nombreCorto);
			
			return query.getSingleResult();
			
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public List<PaisEntity> consultarPaisXFiltros(String nombre, String estado, List<Date> fechas) {
		StringBuilder stBuild = new StringBuilder("SELECT p FROM PaisEntity p WHERE 1=1");
	    Map<String, Object> parametros = new HashMap<>();

	    if ( nombre != null && !nombre.isEmpty()) {
	        stBuild.append(" AND LOWER(p.nombrePais) LIKE :nombrePais");
	        parametros.put("nombrePais", "%" + nombre.toLowerCase() + "%");
	    }

	    if ( estado!= null && !estado.isEmpty()) {
	        stBuild.append(" AND p.idEstado = :estado");
	        parametros.put("estado", estado);
	    }

	    if ( fechas != null && !fechas.isEmpty() ) {

	        if ( fechas.size() == 2 && fechas.get(0) != null && fechas.get(1) != null ) {
	        	
	            stBuild.append(" AND p.fechaCreacion BETWEEN :fechaInicio AND :fechaFin");
	            parametros.put("fechaInicio", fechas.get(0));
	            parametros.put("fechaFin", fechas.get(1));
	            
	        }
	    }
	    
	    TypedQuery<PaisEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), PaisEntity.class);
	    parametros.forEach(query::setParameter);
	    return query.getResultList();
	}

}
