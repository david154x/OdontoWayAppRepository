package com.drr.odontoway.repository;

import java.util.List;

import com.drr.odontoway.core.GenericRepository;
import com.drr.odontoway.entity.SeguimientoPacienteEntity;

public interface SeguimientoPacienteRepository extends GenericRepository<SeguimientoPacienteEntity, Integer> {
	
	List<SeguimientoPacienteEntity> consultarSeguimientoPacienteXIdPaciente(Integer idPaciente);

}
