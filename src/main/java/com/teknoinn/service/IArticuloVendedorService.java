package com.teknoinn.service;

import java.util.List;

import com.teknoinn.model.ArticuloVendedor;

public interface IArticuloVendedorService  {
	
	
	List<ArticuloVendedor> listarArticulosPorVendedor(Integer idVendedor);
	
	

}
