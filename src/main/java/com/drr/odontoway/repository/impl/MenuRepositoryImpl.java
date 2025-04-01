package com.drr.odontoway.repository.impl;

import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.MenuEntity;
import com.drr.odontoway.repository.MenuRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MenuRepositoryImpl extends GenericRepositoryImpl<MenuEntity, Integer> implements MenuRepository {

	public MenuRepositoryImpl() {
		super(MenuEntity.class);
	}

}
