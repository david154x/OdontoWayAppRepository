package com.drr.odontoway.repository.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.drr.odontoway.core.JpaUtil;
import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.UsuarioEntity;
import com.drr.odontoway.repository.UsuarioRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class UsuarioRepositoryImpl extends GenericRepositoryImpl<UsuarioEntity, Integer> implements UsuarioRepository {

	public UsuarioRepositoryImpl() {
		super(UsuarioEntity.class);
	}
	
	@Inject
	private JpaUtil jpaUtil;
	
	@Override
	public Boolean validarNumeroDocumentoExistente(String numeroDocumento) {
		try {
			StringBuilder stBuild = new StringBuilder();
			stBuild.append("SELECT u FROM UsuarioEntity u \n")
				   .append("WHERE \n")
				   .append("u.numeroDocumento = :numeroDocumento \n");
			
			TypedQuery<UsuarioEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), UsuarioEntity.class);
			
			query.setParameter("numeroDocumento", numeroDocumento);
			
			UsuarioEntity usuarioEncontrado = query.getSingleResult();
			
			if ( usuarioEncontrado != null && !Objects.isNull(usuarioEncontrado) )
				return Boolean.TRUE;
			
		} catch (Exception e) {
			e.getMessage();
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean existeUsuario(String nombreUsuario) {
		try {
			StringBuilder stBuild = new StringBuilder();
			stBuild.append("SELECT u FROM UsuarioEntity u \n")
				   .append("WHERE \n")
				   .append("u.nombre LIKE :nombreUsuario \n");
			
			TypedQuery<UsuarioEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), UsuarioEntity.class);
			
			query.setParameter("nombreUsuario", nombreUsuario);
			
			UsuarioEntity usuarioEncontrado = query.getSingleResult();
			
			if ( usuarioEncontrado != null && !Objects.isNull(usuarioEncontrado) )
				return Boolean.TRUE;
			
		} catch (Exception e) {
			e.getMessage();
		}
		return Boolean.FALSE;
	}
	
	@Override
	public UsuarioEntity consultarUsarioXNombre(String nombreUsuario) {
		try {
			StringBuilder stBuild = new StringBuilder();
			stBuild.append("SELECT u FROM UsuarioEntity u \n")
				   .append("WHERE \n")
				   .append("u.nombre = :nombreUsuario \n")
				   .append("AND u.estado = :estado \n");
			
			TypedQuery<UsuarioEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), UsuarioEntity.class);
			
			query.setParameter("nombreUsuario", nombreUsuario);
			query.setParameter("estado", "A");
			
			UsuarioEntity usuarioEncontrado = query.getSingleResult();
			
			if ( usuarioEncontrado != null && !Objects.isNull(usuarioEncontrado) )
				return usuarioEncontrado;
			
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public List<UsuarioEntity> consultarUsuarioXFiltro(Integer idRol, Integer idPais, Integer idCiudad,
			String nombreUsuario, String estado, List<Date> fechas) {
		StringBuilder stBuild = new StringBuilder("SELECT u FROM UsuarioEntity u WHERE 1=1");
	    Map<String, Object> parametros = new HashMap<>();
	    
	    if ( idRol != null ) {
	        stBuild.append(" AND u.rolEntity.idRol = :idRol");
	        parametros.put("idRol", idRol);
	    }
	    
	    if ( idPais != null ) {
	        stBuild.append(" AND u.pais.idPais = :idPais");
	        parametros.put("idPais", idPais);
	    }
	    
	    if ( idCiudad != null ) {
	        stBuild.append(" AND u.ciudad.idCiudad = :idCiudad");
	        parametros.put("idCiudad", idCiudad);
	    }

	    if ( nombreUsuario != null && !nombreUsuario.isEmpty()) {
	        stBuild.append(" AND LOWER(u.nombre) = :nombreUsuario");
	        parametros.put("nombreUsuario", nombreUsuario);
	    }

	    if ( estado!= null && !estado.isEmpty()) {
	        stBuild.append(" AND u.estado = :estado");
	        parametros.put("estado", estado);
	    }

	    if ( fechas != null && !fechas.isEmpty() ) {

	        if ( fechas.size() == 2 && fechas.get(0) != null && fechas.get(1) != null ) {
	        	
	            stBuild.append(" AND u.fechaCreacion BETWEEN :fechaInicio AND :fechaFin");
	            parametros.put("fechaInicio", fechas.get(0));
	            parametros.put("fechaFin", fechas.get(1));
	            
	        }
	    }
	    
	    TypedQuery<UsuarioEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), UsuarioEntity.class);
	    parametros.forEach(query::setParameter);
	    return query.getResultList();
	}

	@Override
	public List<UsuarioEntity> buscarUsuariosXCoincidencia(String busquedaUsuario) {
		try {
			StringBuilder stBuild = new StringBuilder("");
			stBuild.append("SELECT u FROM UsuarioEntity u ")
				   .append("WHERE ")
				   .append("u.nombre LIKE :busquedaUsuario ");
			
			TypedQuery<UsuarioEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), UsuarioEntity.class);
			
			query.setParameter("busquedaUsuario", "%"+busquedaUsuario+"%");
		    
		    return query.getResultList();
		    
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

}
