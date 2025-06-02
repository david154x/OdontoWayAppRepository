package com.drr.odontoway.repository;

import java.util.List;

import com.drr.odontoway.core.GenericRepository;
import com.drr.odontoway.entity.PerfilUsuarioEntity;

public interface PerfilUsuarioRepository extends GenericRepository<PerfilUsuarioEntity, Integer> {
	
	List<PerfilUsuarioEntity> consultarPerfilesXUsuario(Integer idUsuario);
	
	Boolean consultarSiUsuarioYaTienePerfil(Integer idUsuario, Integer idPerfil);

}
