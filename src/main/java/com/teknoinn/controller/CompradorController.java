package com.teknoinn.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.teknoinn.exception.ModeloNotFoundException;
import com.teknoinn.model.Comprador;
import com.teknoinn.service.ICompradorService;


@RestController
@RequestMapping("/compradores")
//@CrossOrigin()
public class CompradorController {
	
	@Autowired
	private ICompradorService service;
	
	@GetMapping
	public ResponseEntity<List<Comprador>> listar() {
		List<Comprador> lista = service.listar();
		return new ResponseEntity<List<Comprador>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Comprador> listarPorId(@PathVariable("id") Integer id) {
		Comprador comprad = service.leerPorId(id);
		if (comprad.getIdComprador() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Comprador>(comprad, HttpStatus.OK);
	}
	
	//nivel 1
	@GetMapping("/pageable")
	public ResponseEntity<Page<Comprador>> listarPageable(Pageable pageable) {
		Page<Comprador> compradores = service.listarPageable(pageable);
		return new ResponseEntity<Page<Comprador>>(compradores, HttpStatus.OK);
	}
	
	// nivel 2
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Comprador comprador) {
		Comprador pac = service.registrar(comprador);
		//compradores/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comprador.getIdComprador()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Comprador> modificar(@Valid @RequestBody Comprador comprador) {
		Comprador comprad = service.modificar(comprador);
		return new ResponseEntity<Comprador>(comprad, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Comprador comprad = service.leerPorId(id);
		if (comprad.getIdComprador() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
