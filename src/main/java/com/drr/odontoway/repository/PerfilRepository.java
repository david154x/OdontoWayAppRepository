package com.drr.odontoway.repository;

import java.util.Date;
import java.util.List;

import com.drr.odontoway.core.GenericRepository;
import com.drr.odontoway.entity.PerfilEntity;

public interface PerfilRepository extends GenericRepository<PerfilEntity, Integer> {
	
	PerfilEntity consultarPerfilXNombre(String nombrePerfil);
	
	List<PerfilEntity> consultarPerfilXFiltros(String nombre, String descripcion, String estado, List<Date> fechas);
	
	List<PerfilEntity> buscarPerfilesXCoincidencia(String busquedaPerfil);
	
}
