package com.drr.odontoway.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proy_citas")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CitaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cita")
	private Integer idCita;

	@ManyToOne
	@JoinColumn(name = "id_proc_us", nullable = false)
	private ProcedimientoUsuarioEntity procedimientoUsuarioEntity;

	@ManyToOne
	@JoinColumn(name = "id_paci", nullable = false)
	private PacienteEntity pacienteEntity;

	@Temporal(TemporalType.DATE)
	@Column(name = "fe_cita", nullable = false)
	private Date fecha;

	@Temporal(TemporalType.TIME)
	@Column(name = "hr_inic_cita", nullable = false)
	private Date horaInicio;

	@Temporal(TemporalType.TIME)
	@Column(name = "hr_fin_cita", nullable = false)
	private Date horaFin;

	@Column(name = "de_obse")
	private String observaciones;

	@Column(name = "id_esta", length = 1, nullable = false)
	private String idEstado;

	@Temporal(TemporalType.DATE)
	@Column(name = "fe_crea", nullable = false)
	private Date fechaCreacion;

	@Column(name = "de_usua_crea", nullable = false)
	private String usuarioCreacion;

}
