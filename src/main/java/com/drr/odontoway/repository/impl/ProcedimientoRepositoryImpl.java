package com.drr.odontoway.repository.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.drr.odontoway.core.JpaUtil;
import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.CitaEntity;
import com.drr.odontoway.entity.ProcedimientoEntity;
import com.drr.odontoway.repository.ProcedimientoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class ProcedimientoRepositoryImpl extends GenericRepositoryImpl<ProcedimientoEntity, Integer> implements ProcedimientoRepository {

	public ProcedimientoRepositoryImpl() {
		super(ProcedimientoEntity.class);
	}
	
	@Inject
	private JpaUtil jpaUtil;

	@Override
	public List<ProcedimientoEntity> consultarProcedimientosXTipo(String tipoProcedimiento) {
		try {
			
			StringBuilder stBuild = new StringBuilder();
			stBuild.append("SELECT ")
				   .append("pro ")
				   .append("FROM ProcedimientoEntity pro ")
				   .append("WHERE ")
				   .append("pro.tipoProcedimiento = :tipoProcedimiento ");
			
		    TypedQuery<ProcedimientoEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), ProcedimientoEntity.class);
		    query.setParameter("tipoProcedimiento", tipoProcedimiento);
		    
		    return query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProcedimientoEntity> consultarProcedimientosXFiltro(String tipoProcedimiento, String idEstado, List<Date> lstFechas) {
		StringBuilder stBuild = new StringBuilder("SELECT pro FROM ProcedimientoEntity pro WHERE 1=1");
	    Map<String, Object> parametros = new HashMap<>();
	    
	    if ( tipoProcedimiento != null && !tipoProcedimiento.isEmpty()) {
	        stBuild.append(" AND pro.tipoProcedimiento = :tipoProcedimiento");
	        parametros.put("tipoProcedimiento", tipoProcedimiento);
	    }
	    
	    if ( idEstado != null && !idEstado.isEmpty()) {
	        stBuild.append(" AND pro.idEstado = :idEstado");
	        parametros.put("idEstado", idEstado);
	    }

	    if ( lstFechas != null && !lstFechas.isEmpty() ) {

	        if ( lstFechas.size() == 2 && lstFechas.get(0) != null && lstFechas.get(1) != null ) {
	        	
	            stBuild.append(" AND pro.fechaCreacion BETWEEN :fechaInicio AND :fechaFin");
	            parametros.put("fechaInicio", lstFechas.get(0));
	            parametros.put("fechaFin", lstFechas.get(1));
	            
	        }
	    }
	    
	    TypedQuery<ProcedimientoEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), ProcedimientoEntity.class);
	    parametros.forEach(query::setParameter);
	    return query.getResultList();
	}

}
