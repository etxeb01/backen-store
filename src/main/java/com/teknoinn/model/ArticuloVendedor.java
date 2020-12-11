package com.teknoinn.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name = "articulo_vendedor")
@IdClass(ArticuloVendedorPK.class)
public class ArticuloVendedor {
	
	
	@Id
	private Vendedor vendedor;
	
	@Id
	private Articulo articulo;

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	

	

	
}
