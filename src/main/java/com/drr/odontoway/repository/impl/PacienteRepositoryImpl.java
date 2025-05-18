package com.drr.odontoway.repository.impl;

import com.drr.odontoway.core.JpaUtil;
import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.PacienteEntity;
import com.drr.odontoway.repository.PacienteRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class PacienteRepositoryImpl extends GenericRepositoryImpl<PacienteEntity, Integer> implements PacienteRepository {

	public PacienteRepositoryImpl() {
		super(PacienteEntity.class);
	}
	
	@Inject
	private JpaUtil jpaUtil;

	@Override
	public PacienteEntity consultarPacienteXTipoYNumeroDocumento(String tipoDocumento, String numeroDocumentoPaciente) {
		try {
			
			EntityManager em = this.jpaUtil.getEntityManager();

	        StringBuilder stBuild = new StringBuilder();
	        stBuild.append("SELECT p FROM PacienteEntity p \n")
	               .append("WHERE \n")
	               .append("p.tipoDocumento = :tipoDocumento ")
	               .append("AND p.numeroDocumento = :numeroDocumentoPaciente");

	        TypedQuery<PacienteEntity> query = em.createQuery(stBuild.toString(), PacienteEntity.class);
	        query.setParameter("tipoDocumento", tipoDocumento);
	        query.setParameter("numeroDocumentoPaciente", numeroDocumentoPaciente);

	        return query.getSingleResult();
			
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

}
