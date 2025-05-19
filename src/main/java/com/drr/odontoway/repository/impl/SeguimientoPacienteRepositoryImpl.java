package com.drr.odontoway.repository.impl;

import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.SeguimientoPacienteEntity;
import com.drr.odontoway.repository.SeguimientoPacienteRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SeguimientoPacienteRepositoryImpl extends GenericRepositoryImpl<SeguimientoPacienteEntity, Integer> implements SeguimientoPacienteRepository {

	public SeguimientoPacienteRepositoryImpl() {
		super(SeguimientoPacienteEntity.class);
	}

}
