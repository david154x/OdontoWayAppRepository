package com.drr.odontoway.repository;

import java.util.Date;
import java.util.List;

import com.drr.odontoway.core.GenericRepository;
import com.drr.odontoway.entity.ProcedimientoEntity;

public interface ProcedimientoRepository extends GenericRepository<ProcedimientoEntity, Integer> {
	
	List<ProcedimientoEntity> consultarProcedimientosXTipo(String tipoProcedimiento);
	
	List<ProcedimientoEntity> consultarProcedimientosXFiltro(String tipoProcedimiento, String idEstado, List<Date> lstFechas);

}
