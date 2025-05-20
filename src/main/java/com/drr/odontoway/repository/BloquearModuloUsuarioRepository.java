package com.drr.odontoway.repository;

import java.util.List;

import com.drr.odontoway.core.GenericRepository;
import com.drr.odontoway.entity.BloqueoUsuarioEntity;

public interface BloquearModuloUsuarioRepository extends GenericRepository<BloqueoUsuarioEntity, Integer> {

	public List<BloqueoUsuarioEntity> consultarBloqueoModuloXIdUsuario(Integer idUsuario);
	
}
