package com.drr.odontoway.repository;

import java.util.Date;
import java.util.List;

import com.drr.odontoway.core.GenericRepository;
import com.drr.odontoway.entity.PacienteEntity;

public interface PacienteRepository extends GenericRepository<PacienteEntity, Integer> {
	
	PacienteEntity consultarPacienteXTipoYNumeroDocumento(String tipoDocumento, String numeroDocumentoPaciente);
	
	List<PacienteEntity> consultarPacienteXFiltro(String numeroDocumento, Integer idPais, Integer idCiudad, String estado, List<Date> fechas);

}
