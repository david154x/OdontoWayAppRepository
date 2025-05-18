package com.drr.odontoway.repository;

import java.util.List;

import com.drr.odontoway.core.GenericRepository;
import com.drr.odontoway.entity.ProcedimientoUsuarioEntity;

public interface ProcedimientoUsuarioRepository extends GenericRepository<ProcedimientoUsuarioEntity, Integer> {
	
	List<ProcedimientoUsuarioEntity> consultarProcedimientosXUsuario(Integer idUsuario);

}
