package com.drr.odontoway.repository.impl;

import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.EmailPacienteEntity;
import com.drr.odontoway.repository.EmailPacienteRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmailPacienteRepositoryImpl extends GenericRepositoryImpl<EmailPacienteEntity, Integer> implements EmailPacienteRepository {

	public EmailPacienteRepositoryImpl() {
		super(EmailPacienteEntity.class);
	}

}
