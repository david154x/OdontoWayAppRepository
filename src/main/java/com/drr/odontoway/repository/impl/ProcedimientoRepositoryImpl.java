package com.drr.odontoway.repository.impl;

import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.ProcedimientoEntity;
import com.drr.odontoway.repository.ProcedimientoRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProcedimientoRepositoryImpl extends GenericRepositoryImpl<ProcedimientoEntity, Integer> implements ProcedimientoRepository {

	public ProcedimientoRepositoryImpl() {
		super(ProcedimientoEntity.class);
	}

}
