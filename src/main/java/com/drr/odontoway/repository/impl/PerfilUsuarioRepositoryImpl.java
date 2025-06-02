package com.drr.odontoway.repository.impl;

import java.util.List;
import java.util.Objects;

import com.drr.odontoway.core.JpaUtil;
import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.PerfilUsuarioEntity;
import com.drr.odontoway.repository.PerfilUsuarioRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class PerfilUsuarioRepositoryImpl extends GenericRepositoryImpl<PerfilUsuarioEntity, Integer> implements PerfilUsuarioRepository {

	public PerfilUsuarioRepositoryImpl() {
		super(PerfilUsuarioEntity.class);
	}
	
	@Inject
	private JpaUtil jpaUtil;

	@Override
	public List<PerfilUsuarioEntity> consultarPerfilesXUsuario(Integer idUsuario) {
		try {
			EntityManager em = this.jpaUtil.getEntityManager();
			
			StringBuilder stBuild = new StringBuilder();
			stBuild.append("SELECT pu FROM PerfilUsuarioEntity pu \n")
				   .append("WHERE \n")
				   .append("pu.usuarioEntity.idUsuario = :idUsuario \n");
			
			Query query = em.createQuery(stBuild.toString());
			
			query.setParameter("idUsuario", idUsuario);
			
			@SuppressWarnings("unchecked")
			List<PerfilUsuarioEntity> lstPerfilesUsuario = query.getResultList();
			
			if ( lstPerfilesUsuario != null && !lstPerfilesUsuario.isEmpty() )
				return lstPerfilesUsuario;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean consultarSiUsuarioYaTienePerfil(Integer idUsuario, Integer idPerfil) {
		try {
			
			StringBuilder stBuild = new StringBuilder();
			stBuild.append("SELECT pu FROM PerfilUsuarioEntity pu \n")
				   .append("WHERE \n")
				   .append("pu.usuarioEntity.idUsuario = :idUsuario \n")
				   .append("AND pu.perfilEntity.idPerfil = :idPerfil \n");
			
			TypedQuery<PerfilUsuarioEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), PerfilUsuarioEntity.class);
			
			query.setParameter("idUsuario", idUsuario);
			query.setParameter("idPerfil", idPerfil);
			
			PerfilUsuarioEntity usuarioPerfilEncontrado = query.getSingleResult();
			
			if ( usuarioPerfilEncontrado != null && !Objects.isNull(usuarioPerfilEncontrado) )
				return Boolean.TRUE;
			
		} catch (Exception e) {
			e.getMessage();
		}
		return Boolean.FALSE;
	}

}
