package com.teknoinn.dto;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.teknoinn.model.Vendedor;
import com.teknoinn.model.Articulo;
import com.teknoinn.model.Comprador;

public class EnvioDTO extends ResourceSupport {
	
	private Integer idEnvio;
	private Vendedor vendedor;
	private Comprador comprador;
	
	private Double importe;
	private List<Articulo> articulos;
	
	
	public Integer getIdEnvio() {
		return idEnvio;
	}
	public void setIdEnvio(Integer idEnvio) {
		this.idEnvio = idEnvio;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Comprador getComprador() {
		return comprador;
	}
	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	public List<Articulo> getArticulos() {
		return articulos;
	}
	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	
	
	
	
	
}
