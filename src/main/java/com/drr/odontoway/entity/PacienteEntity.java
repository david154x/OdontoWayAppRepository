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
@Table(name = "proy_pacientes")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PacienteEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_paci")
	private Integer idPaciente;
	
	@Column(name = "ti_docu", nullable = false, length = 50)
	private String tipoDocumento;
	
	@Column(name = "nu_docu", nullable = false)
    private String numeroDocumento;
	
	@Column(name = "de_nomb_1", nullable = false, length = 50)
    private String primerNombre;

    @Column(name = "de_nomb_2", length = 50)
    private String segundoNombre;

    @Column(name = "de_ape_1", nullable = false, length = 50)
    private String primerApellido;

    @Column(name = "de_ape_2", length = 50)
    private String segundoApellido;
    
    @ManyToOne
    @JoinColumn(name = "id_pais", nullable = false)
    private PaisEntity paisEntity;

    @ManyToOne
    @JoinColumn(name = "id_ciud", nullable = false)
    private CiudadEntity ciudadEntity;
	
    @Column(name = "ge_paci", nullable = false, length = 1)
    private String genero;

    @Temporal(TemporalType.DATE)
    @Column(name = "fe_naci", nullable = false)
    private Date fechaNacimiento;
    
    @Column(name = "es_civi_paci", nullable = true)
    private String estadoCivil;
    
    @Column(name = "de_ocup_paci", nullable = true)
    private String ocupacion;
    
    @Column(name="id_auto_trat",  nullable = false, length = 1)
    private String idAutorizaTratamientoDatos;

    @Column(name = "id_esta", nullable = false, length = 1)
    private String idEstado;

    @Temporal(TemporalType.DATE)
    @Column(name = "fe_crea", nullable = false)
    private Date fechaCreacion;

    @Column(name = "de_usua_crea", nullable = false, length = 30)
    private String usuarioCreacion;

}
