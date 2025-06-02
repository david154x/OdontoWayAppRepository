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
@Table(name = "proy_ciudades")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CiudadEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ciud")
	private Integer idCiudad;
	
	@ManyToOne
	@JoinColumn(name = "id_pais", nullable = false)
	private PaisEntity paisEntity;
	
	@Column(name = "de_nomb_ciud", length = 50, nullable = false)
	private String nombreCiudad;

	@Column(name = "de_nomb_cort", length = 3, nullable = false)
	private String nombreCorto;

	@Column(name = "id_esta", length = 1, nullable = false)
	private String idEstado;

	@Temporal(TemporalType.DATE)
	@Column(name = "fe_crea", nullable = false)
	private Date fechaCreacion;

	@Column(name = "de_usua_crea", nullable = false)
	private String usuarioCreacion;

}
