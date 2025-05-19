package com.drr.odontoway.repository;

import java.util.List;

import com.drr.odontoway.core.GenericRepository;
import com.drr.odontoway.entity.AdjuntoSeguimientoEntity;

public interface AdjuntoSeguimientoPacienteRepository extends GenericRepository<AdjuntoSeguimientoEntity, Integer> {
	
	List<AdjuntoSeguimientoEntity> consultarAdjuntosSeguimientoXIdSeguimientoPaciente(Integer idSeguimientoPaciente);

}
