package com.drr.odontoway.repository.impl;

import java.util.Date;
import java.util.List;

import com.drr.odontoway.core.JpaUtil;
import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.CitaEntity;
import com.drr.odontoway.repository.CitaRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class CitaRepositoryImpl extends GenericRepositoryImpl<CitaEntity, Integer> implements CitaRepository {

	public CitaRepositoryImpl() {
		super(CitaEntity.class);
	}
	
	@Inject
	private JpaUtil jpaUtil;

	@Override
	public List<CitaEntity> consultarCitasXProcedimientoUsuarioYFecha(Integer procedimientoUsuario, Date fecha) {
		try {
			
			StringBuilder stBuild = new StringBuilder();
			stBuild.append("SELECT ci FROM CitaEntity ci \n")
				   .append("WHERE \n")
				   .append("ci.procedimientoUsuarioEntity.idProcedimientoUsuario = :procedimientoUsuario \n")
				   .append("AND ci.fecha = :fecha \n");
			
			TypedQuery<CitaEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), CitaEntity.class);
			
			query.setParameter("procedimientoUsuario", procedimientoUsuario);
			query.setParameter("fecha", fecha);
			
			List<CitaEntity> lstCitas = query.getResultList();
			
			if ( lstCitas != null && !lstCitas.isEmpty() )
				return lstCitas;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
