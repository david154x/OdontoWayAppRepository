package com.drr.odontoway.repository;

import java.util.Date;
import java.util.List;

import com.drr.odontoway.core.GenericRepository;
import com.drr.odontoway.entity.CiudadEntity;

public interface CiudadRepository extends GenericRepository<CiudadEntity, Integer> {
	
	CiudadEntity consultarSiExisteCiudadXPais(Integer idPais, String nombreCiudad);
	
	List<CiudadEntity> consultarCiudadXFiltros(Integer idPais, String nombre, String estado, List<Date> fechas);
	
	List<CiudadEntity> consultarCiudadesXPais(Integer idPais);
	
}
