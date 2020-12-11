package com.teknoinn.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información del envio")
@Entity
@Table(name = "envio")
public class Envio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEnvio;
	
	@ManyToOne
	@JoinColumn(name = "id_comprador", nullable = false)
	@ApiModelProperty(notes = "Comprador")
	private Comprador comprador;
	
	@ManyToOne
	@ApiModelProperty(notes = "Vendedor")
	@JoinColumn(name = "id_vendedor", nullable = false)
	private Vendedor vendedor;
	
	@OneToOne
	@ApiModelProperty(notes = "Pago")
	@JoinColumn(name = "id_pago", nullable = false)
	private Pago pago;
	
	@ApiModelProperty(notes = "Lista de articulos")
	@OneToMany(mappedBy = "envio", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Articulo> articulos;
	
	
	@ApiModelProperty(notes = "Dirección envio debe tener minimo 5 caracteres")
	@Size(min = 5, max = 150, message = "Dirección debe tener minimo 5 caracteres")
	@Column(name = "direccion", nullable = true, length = 150)
	private String direccionEnvio;
	
	@ApiModelProperty(notes = "Fecha envío")
	private LocalDateTime fechaEnvio;

	public Integer getIdEnvio() {
		return idEnvio;
	}

	public void setIdEnvio(Integer idEnvio) {
		this.idEnvio = idEnvio;
	}

	public String getDireccionEnvio() {
		return direccionEnvio;
	}

	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	public LocalDateTime getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(LocalDateTime fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
	
	

}
