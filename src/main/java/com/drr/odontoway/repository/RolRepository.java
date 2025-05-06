package com.drr.odontoway.repository;

import java.util.Date;
import java.util.List;

import com.drr.odontoway.core.GenericRepository;
import com.drr.odontoway.entity.RolEntity;

public interface RolRepository extends GenericRepository<RolEntity, Integer> {
	
	RolEntity consultarRolXNombreRol(String nombreRol);
	
	List<RolEntity> consultarRolXFiltros(String nombre, String descripcion, String estado, List<Date> fechas);

}
