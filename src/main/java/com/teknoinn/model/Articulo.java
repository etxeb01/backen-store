package com.teknoinn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información del articulo")
@Entity
@Table(name = "articulo")
public class Articulo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idArticulo;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_envio", nullable = false, foreignKey = @ForeignKey(name = "FK_articulo_envio"))
	private Envio envio;
	
	@ApiModelProperty(notes = "Nombre Articulo debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre Articulo debe tener minimo 3 caracteres")
	@Column(name = "nombre_articulo", nullable = false, unique = true)
	private String nombreArticulo;
	
	@ApiModelProperty(notes = "Precio del articulo, monto expresado en $")
	@Size(min = 0, message = "Precio articulo")	
	@Column(name = "precio_articulo", nullable = false, unique = true)
	private Double precioArticulo;

	public Integer getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(Integer idArticulo) {
		this.idArticulo = idArticulo;
	}

	public Envio getEnvio() {
		return envio;
	}

	public void setEnvio(Envio envio) {
		this.envio = envio;
	}

	public String getNombreArticulo() {
		return nombreArticulo;
	}

	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}

	public Double getPrecioArticulo() {
		return precioArticulo;
	}

	public void setPrecioArticulo(Double precioArticulo) {
		this.precioArticulo = precioArticulo;
	}
	
	
	
}
