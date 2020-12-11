package com.teknoinn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teknoinn.model.ArticuloVendedor;
import com.teknoinn.repo.IArticuloVendedorRepo;
import com.teknoinn.service.IArticuloVendedorService;

@Service
public class ArticuloVendedorServiceImpl implements IArticuloVendedorService{
	
	@Autowired
	private IArticuloVendedorRepo repo;
	

	@Override
	public List<ArticuloVendedor> listarArticulosPorVendedor(Integer idvendedor) {
		return repo.listarArticulosPorVendedor(idvendedor);
	}

	



}
