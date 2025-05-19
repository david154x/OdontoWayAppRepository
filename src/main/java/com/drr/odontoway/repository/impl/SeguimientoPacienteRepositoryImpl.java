package com.drr.odontoway.repository.impl;

import java.util.List;

import com.drr.odontoway.core.JpaUtil;
import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.SeguimientoPacienteEntity;
import com.drr.odontoway.repository.SeguimientoPacienteRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class SeguimientoPacienteRepositoryImpl extends GenericRepositoryImpl<SeguimientoPacienteEntity, Integer> implements SeguimientoPacienteRepository {

	public SeguimientoPacienteRepositoryImpl() {
		super(SeguimientoPacienteEntity.class);
	}
	
	@Inject
	private JpaUtil jpaUtil;

	@Override
	public List<SeguimientoPacienteEntity> consultarSeguimientoPacienteXIdPaciente(Integer idPaciente) {
		try {
			
			StringBuilder stBuild = new StringBuilder();
			stBuild.append("SELECT pa FROM SeguimientoPacienteEntity pa ")
				   .append("WHERE ")
				   .append("pa.citaEntity.pacienteEntity.idPaciente = :idPaciente ");
		    
		    TypedQuery<SeguimientoPacienteEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), SeguimientoPacienteEntity.class);
		    
		    query.setParameter("idPaciente", idPaciente);
		    
		    return query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
