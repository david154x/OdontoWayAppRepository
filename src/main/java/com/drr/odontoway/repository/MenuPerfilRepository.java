package com.drr.odontoway.repository;

import java.util.List;

import com.drr.odontoway.core.GenericRepository;
import com.drr.odontoway.entity.MenuPerfilEntity;

public interface MenuPerfilRepository extends GenericRepository<MenuPerfilEntity, Integer> {
	
	List<MenuPerfilEntity> consultarMenuPerfilXCodigoPerfil(Integer codigoPerfil);

}
