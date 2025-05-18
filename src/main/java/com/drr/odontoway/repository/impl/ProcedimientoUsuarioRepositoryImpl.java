package com.drr.odontoway.repository.impl;

import java.util.List;

import com.drr.odontoway.core.JpaUtil;
import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.ProcedimientoUsuarioEntity;
import com.drr.odontoway.repository.ProcedimientoUsuarioRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class ProcedimientoUsuarioRepositoryImpl extends GenericRepositoryImpl<ProcedimientoUsuarioEntity, Integer> implements ProcedimientoUsuarioRepository {

	public ProcedimientoUsuarioRepositoryImpl() {
		super(ProcedimientoUsuarioEntity.class);
	}
	
	@Inject
	private JpaUtil jpaUtil;

	@Override
	public List<ProcedimientoUsuarioEntity> consultarProcedimientosXUsuario(Integer idUsuario) {
		try {
			
			StringBuilder stBuild = new StringBuilder();
			stBuild.append("SELECT pru FROM ProcedimientoUsuarioEntity pru \n")
				   .append("WHERE \n")
				   .append("pru.usuarioEntity.idUsuario = :idUsuario \n");
			
			TypedQuery<ProcedimientoUsuarioEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), ProcedimientoUsuarioEntity.class);
			
			query.setParameter("idUsuario", idUsuario);
			
			List<ProcedimientoUsuarioEntity> lstProcedimientoUsuario = query.getResultList();
			
			if ( lstProcedimientoUsuario != null && !lstProcedimientoUsuario.isEmpty() )
				return lstProcedimientoUsuario;
			
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

}
