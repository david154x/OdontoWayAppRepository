package com.drr.odontoway.repository.impl;

import java.util.List;

import com.drr.odontoway.core.JpaUtil;
import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.BloqueoUsuarioEntity;
import com.drr.odontoway.repository.BloquearModuloUsuarioRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class BloquearModuloUsuarioRepositoryImpl extends GenericRepositoryImpl<BloqueoUsuarioEntity, Integer> implements BloquearModuloUsuarioRepository {

	public BloquearModuloUsuarioRepositoryImpl() {
		super(BloqueoUsuarioEntity.class);
	}
	
	@Inject
	private JpaUtil jpaUtil;

	@Override
	public List<BloqueoUsuarioEntity> consultarBloqueoModuloXIdUsuario(Integer idUsuario) {
		try {
			
			StringBuilder stBuild = new StringBuilder();
			stBuild.append("SELECT blo FROM BloqueoUsuarioEntity blo ")
				   .append("WHERE ")
				   .append("blo.usuarioEntity.idUsuario ");
		    
		    TypedQuery<BloqueoUsuarioEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), BloqueoUsuarioEntity.class);
		    
		    query.setParameter("idUsuario", idUsuario);
		    
		    return query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
