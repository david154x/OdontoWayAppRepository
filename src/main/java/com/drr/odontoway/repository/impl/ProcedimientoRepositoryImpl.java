package com.drr.odontoway.repository.impl;

import java.util.List;

import com.drr.odontoway.core.JpaUtil;
import com.drr.odontoway.core.impl.GenericRepositoryImpl;
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

}
