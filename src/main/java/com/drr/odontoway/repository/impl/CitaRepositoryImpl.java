package com.drr.odontoway.repository.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.drr.odontoway.core.JpaUtil;
import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.CitaEntity;
import com.drr.odontoway.repository.CitaRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class CitaRepositoryImpl extends GenericRepositoryImpl<CitaEntity, Integer> implements CitaRepository {

	public CitaRepositoryImpl() {
		super(CitaEntity.class);
	}
	
	@Inject
	private JpaUtil jpaUtil;

	@Override
	public List<CitaEntity> consultarCitasXProcedimientoUsuarioYFecha(Integer procedimientoUsuario, Date fecha) {
		try {
			
			StringBuilder stBuild = new StringBuilder();
			stBuild.append("SELECT ci FROM CitaEntity ci \n")
				   .append("WHERE \n")
				   .append("ci.procedimientoUsuarioEntity.idProcedimientoUsuario = :procedimientoUsuario \n")
				   .append("AND ci.fecha = :fecha \n")
				   .append("AND ci.idEstado IN (:estadoCita) \n");
			
			TypedQuery<CitaEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), CitaEntity.class);
			
			query.setParameter("procedimientoUsuario", procedimientoUsuario);
			query.setParameter("fecha", fecha);
			query.setParameter("estadoCita", Arrays.asList("A", "C"));
			
			List<CitaEntity> lstCitas = query.getResultList();
			
			if ( lstCitas != null && !lstCitas.isEmpty() )
				return lstCitas;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<CitaEntity> consultarCitasXUsuarioYFechaYEstado(String usuario, Date fecha) {
		try {
			
			StringBuilder stBuild = new StringBuilder();
			stBuild.append("SELECT ci FROM CitaEntity ci \n")
				   .append("WHERE \n")
				   .append("ci.procedimientoUsuarioEntity.usuarioEntity.nombre = :usuario \n")
				   .append("AND ci.fecha = :fecha \n")
				   .append("AND ci.idEstado IN (:estadoCita) \n");
			
			TypedQuery<CitaEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), CitaEntity.class);
			
			query.setParameter("usuario", usuario);
			query.setParameter("fecha", fecha);
			query.setParameter("estadoCita", Arrays.asList("A", "C"));
			
			List<CitaEntity> lstCitas = query.getResultList();
			
			if ( lstCitas != null && !lstCitas.isEmpty() )
				return lstCitas;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CitaEntity> consultarCitasAgendadasXFecha(Date fecha) {
		try {
			
			StringBuilder stBuild = new StringBuilder();
			stBuild.append("SELECT ci FROM CitaEntity ci \n")
				   .append("WHERE \n")
				   .append("ci.fecha = :fecha \n")
				   .append("AND ci.idEstado = :idEstado \n");
			
			TypedQuery<CitaEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), CitaEntity.class);
			
			query.setParameter("fecha", fecha);
			query.setParameter("idEstado", "A");
			
			List<CitaEntity> lstCitas = query.getResultList();
			
			if ( lstCitas != null && !lstCitas.isEmpty() )
				return lstCitas;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CitaEntity> consultarCitasXFiltro(String idEstado, List<Date> lstFechas) {
		StringBuilder stBuild = new StringBuilder("SELECT cit FROM CitaEntity cit WHERE 1=1");
	    Map<String, Object> parametros = new HashMap<>();
	    
	    if ( idEstado != null && !idEstado.isEmpty()) {
	        stBuild.append(" AND cit.idEstado = :idEstado");
	        parametros.put("idEstado", idEstado);
	    }

	    if ( lstFechas != null && !lstFechas.isEmpty() ) {

	        if ( lstFechas.size() == 2 && lstFechas.get(0) != null && lstFechas.get(1) != null ) {
	        	
	            stBuild.append(" AND cit.fechaCreacion BETWEEN :fechaInicio AND :fechaFin");
	            parametros.put("fechaInicio", lstFechas.get(0));
	            parametros.put("fechaFin", lstFechas.get(1));
	            
	        }
	    }
	    
	    TypedQuery<CitaEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), CitaEntity.class);
	    parametros.forEach(query::setParameter);
	    return query.getResultList();
	}

}
