package com.drr.odontoway.repository.impl;

import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.TelefonoPacienteEntity;
import com.drr.odontoway.repository.TelefonoPacienteRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TelefonoPacienteRepositoryImpl extends GenericRepositoryImpl<TelefonoPacienteEntity, Integer> implements TelefonoPacienteRepository  {

	public TelefonoPacienteRepositoryImpl() {
		super(TelefonoPacienteEntity.class);
	}

}
