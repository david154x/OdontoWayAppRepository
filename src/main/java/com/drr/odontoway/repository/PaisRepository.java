package com.drr.odontoway.repository;

import java.util.Date;
import java.util.List;

import com.drr.odontoway.core.GenericRepository;
import com.drr.odontoway.entity.PaisEntity;

public interface PaisRepository extends GenericRepository<PaisEntity, Integer> {
	
	PaisEntity consultarPaisXNombre(String nombrePais);
	
	PaisEntity consultarPaisXNombreCorto(String nombreCorto);
	
	List<PaisEntity> consultarPaisXFiltros(String nombre, String estado, List<Date> fechas);

}
