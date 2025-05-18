package com.drr.odontoway.repository;

import com.drr.odontoway.core.GenericRepository;
import com.drr.odontoway.entity.PacienteEntity;

public interface PacienteRepository extends GenericRepository<PacienteEntity, Integer> {
	
	PacienteEntity consultarPacienteXTipoYNumeroDocumento(String tipoDocumento, String numeroDocumentoPaciente);

}
