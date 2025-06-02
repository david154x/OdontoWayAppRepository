package com.drr.odontoway.entity;

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
@Table(name = "proy_adjuntos_seguimiento")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdjuntoSeguimientoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_adj")
	private Integer idAdjunto;

	@ManyToOne
	@JoinColumn(name = "id_segpa", nullable = false)
	private SeguimientoPacienteEntity seguimientoPacienteEntity;

	@Column(name = "de_nomb_arch", nullable = false, length = 255)
	private String nombreArchivo;

	@Column(name = "de_ruta_arch", nullable = false, length = 100)
	private String rutaArchivo;

	@Column(name = "id_esta", length = 1, nullable = false)
	private String idEstado;

	@Temporal(TemporalType.DATE)
	@Column(name = "fe_crea", nullable = false)
	private Date fechaCreacion;

	@Column(name = "de_usua_crea", nullable = false)
	private String usuarioCreacion;

}
