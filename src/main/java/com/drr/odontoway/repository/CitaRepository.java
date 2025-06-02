package com.drr.odontoway.repository;

import java.util.Date;
import java.util.List;

import com.drr.odontoway.core.GenericRepository;
import com.drr.odontoway.entity.CitaEntity;

public interface CitaRepository extends GenericRepository<CitaEntity, Integer> {
	
	List<CitaEntity> consultarCitasXProcedimientoUsuarioYFecha(Integer procedimientoUsuario, Date fecha);
	
	List<CitaEntity> consultarCitasXUsuarioYFechaYEstado(String usuario, Date fecha);
	
	List<CitaEntity> consultarCitasAgendadasXFecha(Date fecha);
	
	List<CitaEntity> consultarCitasXFiltro(String idEstado, List<Date> lstFechas);

}
