package com.drr.odontoway.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "odtperfi")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PerfilEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_perf")
	private Integer idPerfil;
	
	@Column(name="de_perf", nullable = false)
	private String nombrePerfil;
	
	@Column(name="de_desc_perf", nullable = false)
	private String descripcionPerfil;
	
	@Column(name="id_esta", length = 1, nullable = false)
	private String idEstado;
	
	@Column(name="fe_crea", nullable = false)
	private LocalDate fechaCreacion;
	
	@Column(name="de_usua_crea", nullable = false)
	private String usuarioCreacion;

}
