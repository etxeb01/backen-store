package com.teknoinn.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.teknoinn.model.Articulo;
import com.teknoinn.service.IArticuloService;


@RestController
@RequestMapping("/articulos")
public class ArticuloController {
	
	@Autowired
	private IArticuloService service;
	
	@GetMapping
	public ResponseEntity<List<Articulo>> listar() {
		List<Articulo> lista = service.listar();
		return new ResponseEntity<List<Articulo>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Articulo> listarPorId(@PathVariable("id") Integer id) {
		Articulo obj = service.leerPorId(id);
		if (obj.getIdArticulo() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Articulo>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Articulo articulo) {
		Articulo obj = service.registrar(articulo);
		//articulos/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(articulo.getIdArticulo()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Articulo> modificar(@Valid @RequestBody Articulo articulo) {
		Articulo obj = service.modificar(articulo);
		return new ResponseEntity<Articulo>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Articulo obj = service.leerPorId(id);
		if (obj.getIdArticulo() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
