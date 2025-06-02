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
@Table(name = "proy_menu_perfil")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuPerfilEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_menu_perf")
	private Integer idMenuPerfil;
	
	@ManyToOne
    @JoinColumn(name = "id_menu", nullable = false)
    private MenuEntity menuEntity;

    @ManyToOne
    @JoinColumn(name = "id_perf", nullable = false)
    private PerfilEntity perfilEntity;
    
    @Column(name="id_esta", length = 1, nullable = false)
	private String idEstado;
	
    @Temporal(TemporalType.DATE)
	@Column(name="fe_crea", nullable = false)
	private Date fechaCreacion;
	
	@Column(name="de_usua_crea", nullable = false)
	private String usuarioCreacion;

}
