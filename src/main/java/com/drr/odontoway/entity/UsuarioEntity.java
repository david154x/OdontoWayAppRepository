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
@Table(name = "proy_usuarios")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usua")
    private Integer idUsuario;
    
    @Column(name = "nu_docu_usua", nullable = false)
    private String numeroDocumento;

    @Column(name = "de_nomb_usua", nullable = false)
    private String nombre;

    @Column(name = "de_pass_usua", nullable = false)
    private String pass;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private RolEntity rolEntity;

    @Column(name = "de_nomb_1", nullable = false, length = 50)
    private String primerNombre;

    @Column(name = "de_nomb_2", length = 50)
    private String segundoNombre;

    @Column(name = "de_ape_1", nullable = false, length = 50)
    private String primerApellido;

    @Column(name = "de_ape_2", length = 50)
    private String segundoApellido;

    @Column(name = "de_dire", nullable = false, length = 50)
    private String direccion;

    @Column(name = "de_tel", nullable = false, length = 20)
    private String telefono;

    @Column(name = "de_eml", nullable = false, length = 50)
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_pais", nullable = false)
    private PaisEntity pais;

    @ManyToOne
    @JoinColumn(name = "id_ciud", nullable = false)
    private CiudadEntity ciudad;

    @Column(name = "ge_usua", nullable = false, length = 1)
    private String genero;

    @Temporal(TemporalType.DATE)
    @Column(name = "fe_naci", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "id_esta", nullable = false, length = 1)
    private String estado;

    @Temporal(TemporalType.DATE)
    @Column(name = "fe_crea", nullable = false)
    private Date fechaCreacion;

    @Column(name = "de_usua_crea", nullable = false, length = 30)
    private String usuarioCreacion;
    
}

