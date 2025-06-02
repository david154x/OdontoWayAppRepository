package com.drr.odontoway.repository.impl;

import java.util.List;

import com.drr.odontoway.core.JpaUtil;
import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.MenuPerfilEntity;
import com.drr.odontoway.repository.MenuPerfilRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@ApplicationScoped
public class MenuPerfilRepositoryImpl extends GenericRepositoryImpl<MenuPerfilEntity, Integer> implements MenuPerfilRepository {

	public MenuPerfilRepositoryImpl() {
		super(MenuPerfilEntity.class);
	}
	
	@Inject
	private JpaUtil jpaUtil;

	@Override
	public List<MenuPerfilEntity> consultarMenuPerfilXCodigoPerfil(Integer codigoPerfil) {
		try {
			EntityManager em = this.jpaUtil.getEntityManager();
			
			StringBuilder stBuild = new StringBuilder();
			stBuild.append("SELECT mp FROM MenuPerfilEntity mp \n")
				   .append("WHERE \n")
				   .append("mp.perfilEntity.idPerfil = :codigoPerfil \n");
			
			Query query = em.createQuery(stBuild.toString());
			
			query.setParameter("codigoPerfil", codigoPerfil);
			
			@SuppressWarnings("unchecked")
			List<MenuPerfilEntity> lstMenuXPerfilEncontrado = query.getResultList();
			
			if ( lstMenuXPerfilEncontrado != null && !lstMenuXPerfilEncontrado.isEmpty() )
				return lstMenuXPerfilEncontrado;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
