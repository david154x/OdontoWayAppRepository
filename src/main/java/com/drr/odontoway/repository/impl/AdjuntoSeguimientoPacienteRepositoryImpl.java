package com.drr.odontoway.repository.impl;

import java.util.List;

import com.drr.odontoway.core.JpaUtil;
import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.AdjuntoSeguimientoEntity;
import com.drr.odontoway.repository.AdjuntoSeguimientoPacienteRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class AdjuntoSeguimientoPacienteRepositoryImpl extends GenericRepositoryImpl<AdjuntoSeguimientoEntity, Integer> implements AdjuntoSeguimientoPacienteRepository {

	public AdjuntoSeguimientoPacienteRepositoryImpl() {
		super(AdjuntoSeguimientoEntity.class);
	}
	
	@Inject
	private JpaUtil jpaUtil;

	@Override
	public List<AdjuntoSeguimientoEntity> consultarAdjuntosSeguimientoXIdSeguimientoPaciente(
			Integer idSeguimientoPaciente) {
		try {
			
			StringBuilder stBuild = new StringBuilder();
			stBuild.append("SELECT adj FROM AdjuntoSeguimientoEntity adj ")
				   .append("WHERE ")
				   .append("adj.seguimientoPacienteEntity.idSeguimientoPaciente = :idSeguimientoPaciente ");
		    
		    TypedQuery<AdjuntoSeguimientoEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), AdjuntoSeguimientoEntity.class);
		    
		    query.setParameter("idSeguimientoPaciente", idSeguimientoPaciente);
		    
		    return query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
