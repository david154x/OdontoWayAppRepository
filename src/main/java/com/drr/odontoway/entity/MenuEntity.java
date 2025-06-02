package com.drr.odontoway.entity;

import java.io.Serializable;
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
@Table(name = "proy_menus")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_menu")
	private Integer idMenu;
	
	@Column(name="de_nomb_menu", nullable = false)
	private String nombreMenu;
	
	@Column(name="de_ruta_url", nullable = false)
	private String rutaUrl;
	
	@Column(name="de_nomb_docu", nullable = false)
	private String nombreDocumento;
	
	@Column(name="de_icon_menu", length = 12, nullable = true)
	private String iconoMenu;
	
	@Column(name="id_modu_menu", nullable = true)
	private Integer moduloMenu;
	
	@Column(name="id_sub_menu", nullable = true)
	private Integer subMenu;
	
	@Column(name="de_nomb_view", nullable = true)
	private String nombreClaseView;
	
	@Column(name="cd_nume_item", nullable = false)
	private Integer numeroItem;
	
	@Column(name="id_esta", length = 1, nullable = false)
	private String idEstado;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fe_crea", nullable = false)
	private Date fechaCreacion;
	
	@Column(name="de_usua_crea", nullable = false)
	private String usuarioCreacion;

}
