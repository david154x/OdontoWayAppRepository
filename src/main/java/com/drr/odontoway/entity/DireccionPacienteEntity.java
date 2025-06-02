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
@Table(name = "proy_paciente_direcciones")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DireccionPacienteEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_dirpa")
	private Integer idDireccionPaciente;
	
	@ManyToOne
	@JoinColumn(name="id_paci", nullable = false)
	private PacienteEntity pacienteEntity;
	
	@Column(name="ti_direc", length = 25, nullable = false)
	private String tipoDireccion;
	
	@Column(name="de_direc", length = 50, nullable = false)
	private String direccion;
	
	@Column(name="id_esta", length = 1, nullable = false)
	private String idEstado;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fe_crea", nullable = false)
	private Date fechaCreacion;
	
	@Column(name="de_usua_crea", nullable = false)
	private String usuarioCreacion;

}
