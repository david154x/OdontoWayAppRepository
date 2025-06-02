package com.drr.odontoway.repository.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.drr.odontoway.core.JpaUtil;
import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.RolEntity;
import com.drr.odontoway.repository.RolRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class RolRepositoryImpl extends GenericRepositoryImpl<RolEntity, Integer> implements RolRepository {

	public RolRepositoryImpl() {
		super(RolEntity.class);
	}
	
	@Inject
	private JpaUtil jpaUtil;

	@Override
	public RolEntity consultarRolXNombreRol(String nombreRol) {
		try {
			StringBuilder stBuild = new StringBuilder();
			stBuild.append("SELECT r FROM RolEntity r \n")
				   .append("WHERE \n")
				   .append("r.nombreRol = :nombreRol \n");
			
			TypedQuery<RolEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), RolEntity.class);
			
			query.setParameter("nombreRol", nombreRol);
			
			return query.getSingleResult();
			
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public List<RolEntity> consultarRolXFiltros(String nombre, String descripcion, String estado, List<Date> fechas) {
		
		StringBuilder stBuild = new StringBuilder("SELECT r FROM RolEntity r WHERE 1=1");
	    Map<String, Object> parametros = new HashMap<>();

	    if ( nombre != null && !nombre.isEmpty()) {
	        stBuild.append(" AND LOWER(r.nombreRol) LIKE :nombreRol");
	        parametros.put("nombreRol", "%" + nombre.toLowerCase() + "%");
	    }

	    if ( descripcion != null && !descripcion.isEmpty()) {
	        stBuild.append(" AND LOWER(r.descripcionRol) LIKE :descripcionRol");
	        parametros.put("descripcionRol", "%" + descripcion.toLowerCase() + "%");
	    }

	    if ( estado!= null && !estado.isEmpty()) {
	        stBuild.append(" AND r.idEstado = :estado");
	        parametros.put("estado", estado);
	    }

	    if ( fechas != null && !fechas.isEmpty() ) {

	        if ( fechas.size() == 2 && fechas.get(0) != null && fechas.get(1) != null ) {
	        	
	            stBuild.append(" AND r.fechaCreacion BETWEEN :fechaInicio AND :fechaFin");
	            parametros.put("fechaInicio", fechas.get(0));
	            parametros.put("fechaFin", fechas.get(1));
	            
	        }
	    }
	    
	    TypedQuery<RolEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), RolEntity.class);
	    parametros.forEach(query::setParameter);
	    return query.getResultList();
	}
	
}
