package com.drr.odontoway.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proy_procedimientos")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcedimientoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_proc")
	private Integer idProcedimiento;
	
	@Column(name="de_nomb_proc", nullable = false)
	private String nombreProcedimiento;
	
	@Column(name="de_tipo", nullable = false)
	private String tipoProcedimiento;
	
	@Column(name="de_desc_proc", nullable = false)
	private String descripcionProcedimiento;
	
	@Column(name="ct_cant", nullable = false)
	private Integer cantidad;
	
	@Column(name="de_tiem_dura", nullable = false)
	private String tiempoDuracion;
	
	@Column(name="de_valr_cost", nullable = false)
	private BigDecimal valorCosto;
	
	@Column(name="id_esta", length = 1, nullable = false)
	private String idEstado;
	
    @Temporal(TemporalType.DATE)
	@Column(name="fe_crea", nullable = false)
	private Date fechaCreacion;
	
	@Column(name="de_usua_crea", nullable = false)
	private String usuarioCreacion;
	
	

}
