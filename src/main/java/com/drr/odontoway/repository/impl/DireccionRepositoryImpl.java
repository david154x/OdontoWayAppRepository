package com.drr.odontoway.repository.impl;

import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.DireccionPacienteEntity;
import com.drr.odontoway.repository.DireccionRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DireccionRepositoryImpl extends GenericRepositoryImpl<DireccionPacienteEntity, Integer> implements DireccionRepository {

	public DireccionRepositoryImpl() {
		super(DireccionPacienteEntity.class);
	}

}
