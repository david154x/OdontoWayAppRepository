package com.drr.odontoway.repository.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.drr.odontoway.core.JpaUtil;
import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.PerfilEntity;
import com.drr.odontoway.repository.PerfilRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class PerfilRepositoryImpl extends GenericRepositoryImpl<PerfilEntity, Integer> implements PerfilRepository {

	public PerfilRepositoryImpl() {
		super(PerfilEntity.class);
	}
	
	@Inject
	private JpaUtil jpaUtil;
	
	@Override
	public PerfilEntity consultarPerfilXNombre(String nombrePerfil) {
		try {
			StringBuilder stBuild = new StringBuilder();
			stBuild.append("SELECT pl FROM PerfilEntity pl \n")
				   .append("WHERE \n")
				   .append("pl.nombrePerfil = :nombrePerfil \n");
			
			TypedQuery<PerfilEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), PerfilEntity.class);
			
			query.setParameter("nombrePerfil", nombrePerfil);
			
			return query.getSingleResult();
			
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public List<PerfilEntity> consultarPerfilXFiltros(String nombre, String descripcion, String estado,
			List<Date> fechas) {
		StringBuilder stBuild = new StringBuilder("SELECT pl FROM PerfilEntity pl WHERE 1=1");
	    Map<String, Object> parametros = new HashMap<>();

	    if ( nombre != null && !nombre.isEmpty()) {
	        stBuild.append(" AND LOWER(pl.nombrePerfil) LIKE :nombrePerfil");
	        parametros.put("nombrePerfil", "%" + nombre.toLowerCase() + "%");
	    }

	    if ( descripcion != null && !descripcion.isEmpty()) {
	        stBuild.append(" AND LOWER(pl.descripcionPerfil) LIKE :descripcionPerfil");
	        parametros.put("descripcionPerfil", "%" + descripcion.toLowerCase() + "%");
	    }

	    if ( estado!= null && !estado.isEmpty()) {
	        stBuild.append(" AND pl.idEstado = :estado");
	        parametros.put("estado", estado);
	    }

	    if ( fechas != null && !fechas.isEmpty() ) {

	        if ( fechas.size() == 2 && fechas.get(0) != null && fechas.get(1) != null ) {
	        	
	            stBuild.append(" AND pl.fechaCreacion BETWEEN :fechaInicio AND :fechaFin");
	            parametros.put("fechaInicio", fechas.get(0));
	            parametros.put("fechaFin", fechas.get(1));
	            
	        }
	    }
	    
	    TypedQuery<PerfilEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), PerfilEntity.class);
	    parametros.forEach(query::setParameter);
	    return query.getResultList();
	}

	@Override
	public List<PerfilEntity> buscarPerfilesXCoincidencia(String busquedaPerfil) {
		try {
			StringBuilder stBuild = new StringBuilder("");
			stBuild.append("SELECT p FROM PerfilEntity p ")
				   .append("WHERE ")
				   .append("p.nombrePerfil LIKE :busquedaPerfil ");
			
			TypedQuery<PerfilEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), PerfilEntity.class);
			
			query.setParameter("busquedaPerfil", "%"+busquedaPerfil+"%");
		    
		    return query.getResultList();
		    
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

}
