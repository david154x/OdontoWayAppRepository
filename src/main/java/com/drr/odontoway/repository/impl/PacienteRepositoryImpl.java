package com.drr.odontoway.repository.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.drr.odontoway.core.JpaUtil;
import com.drr.odontoway.core.impl.GenericRepositoryImpl;
import com.drr.odontoway.entity.PacienteEntity;
import com.drr.odontoway.repository.PacienteRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class PacienteRepositoryImpl extends GenericRepositoryImpl<PacienteEntity, Integer> implements PacienteRepository {

	public PacienteRepositoryImpl() {
		super(PacienteEntity.class);
	}
	
	@Inject
	private JpaUtil jpaUtil;

	@Override
	public PacienteEntity consultarPacienteXTipoYNumeroDocumento(String tipoDocumento, String numeroDocumentoPaciente) {
		try {
			
			EntityManager em = this.jpaUtil.getEntityManager();

	        StringBuilder stBuild = new StringBuilder();
	        stBuild.append("SELECT p FROM PacienteEntity p \n")
	               .append("WHERE \n")
	               .append("p.tipoDocumento = :tipoDocumento ")
	               .append("AND p.numeroDocumento = :numeroDocumentoPaciente");

	        TypedQuery<PacienteEntity> query = em.createQuery(stBuild.toString(), PacienteEntity.class);
	        query.setParameter("tipoDocumento", tipoDocumento);
	        query.setParameter("numeroDocumentoPaciente", numeroDocumentoPaciente);

	        return query.getSingleResult();
			
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public List<PacienteEntity> consultarPacienteXFiltro(String numeroDocumento, Integer idPais, Integer idCiudad,
			String estado, List<Date> fechas) {
		StringBuilder stBuild = new StringBuilder("SELECT pa FROM PacienteEntity pa WHERE 1=1");
	    Map<String, Object> parametros = new HashMap<>();
	    
	    if ( numeroDocumento != null && !numeroDocumento.isEmpty() ) {
	        stBuild.append(" AND pa.numeroDocumento = :numeroDocumento");
	        parametros.put("numeroDocumento", numeroDocumento);
	    }
	    
	    if ( idPais != null ) {
	        stBuild.append(" AND pa.paisEntity.idPais = :idPais");
	        parametros.put("idPais", idPais);
	    }
	    
	    if ( idCiudad != null ) {
	        stBuild.append(" AND pa.ciudadEntity.idCiudad = :idCiudad");
	        parametros.put("idCiudad", idCiudad);
	    }

	    if ( estado!= null && !estado.isEmpty()) {
	        stBuild.append(" AND pa.idEstado = :estado");
	        parametros.put("estado", estado);
	    }

	    if ( fechas != null && !fechas.isEmpty() ) {

	        if ( fechas.size() == 2 && fechas.get(0) != null && fechas.get(1) != null ) {
	        	
	            stBuild.append(" AND pa.fechaCreacion BETWEEN :fechaInicio AND :fechaFin");
	            parametros.put("fechaInicio", fechas.get(0));
	            parametros.put("fechaFin", fechas.get(1));
	            
	        }
	    }
	    
	    TypedQuery<PacienteEntity> query = this.jpaUtil.getEntityManager().createQuery(stBuild.toString(), PacienteEntity.class);
	    parametros.forEach(query::setParameter);
	    return query.getResultList();
	}

}
