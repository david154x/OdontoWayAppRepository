package com.drr.odontoway.repository;

import java.util.Date;
import java.util.List;

import com.drr.odontoway.core.GenericRepository;
import com.drr.odontoway.entity.UsuarioEntity;

public interface UsuarioRepository extends GenericRepository<UsuarioEntity, Integer> {
	
	Boolean validarNumeroDocumentoExistente(String numeroDocumento);
	
	Boolean existeUsuario(String nombreUsuario);
	
	UsuarioEntity consultarUsarioXNombre(String nombreUsuario);
	
	List<UsuarioEntity> consultarUsuarioXFiltro(Integer idRol, Integer idPais, Integer idCiudad, String nombreUsuario, String estado, List<Date> fechas);
	
	List<UsuarioEntity> buscarUsuariosXCoincidencia(String busquedaUsuario);

}
