package com.drr.odontoway.repository.impl;

import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.AdjuntoSeguimientoEntity;
import com.drr.odontoway.repository.AdjuntoSeguimientoPacienteRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AdjuntoSeguimientoPacienteRepositoryImpl extends GenericRepositoryImpl<AdjuntoSeguimientoEntity, Integer> implements AdjuntoSeguimientoPacienteRepository {

	public AdjuntoSeguimientoPacienteRepositoryImpl() {
		super(AdjuntoSeguimientoEntity.class);
	}

}
