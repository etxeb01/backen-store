package com.teknoinn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teknoinn.model.ArticuloVendedor;
import com.teknoinn.service.IArticuloVendedorService;

@RestController
@RequestMapping("/consultaarticulos")
public class ArticuloVendedorController {
	
	@Autowired
	private IArticuloVendedorService service;
	
	@GetMapping(value = "/{idVendedor}")
	public ResponseEntity<List<ArticuloVendedor>> listar(@PathVariable("idVendedor") Integer idvendedor) {
		List<ArticuloVendedor> articulosVendedor = new ArrayList<>();
		articulosVendedor = service.listarArticulosPorVendedor(idvendedor);
		return new ResponseEntity<List<ArticuloVendedor>>(articulosVendedor, HttpStatus.OK);
	}
}
