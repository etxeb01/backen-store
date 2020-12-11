package com.teknoinn.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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


import com.teknoinn.dto.EnvioDTO;
import com.teknoinn.dto.FiltroCompraDTO;
import com.teknoinn.exception.ModeloNotFoundException;
import com.teknoinn.model.Envio;
import com.teknoinn.service.IEnvioService;


@RestController
@RequestMapping("/envios")
public class EnvioController {
	
	@Autowired
	private IEnvioService service;

	
	@GetMapping
	public ResponseEntity<List<Envio>> listar(){
		 List<Envio> lista = service.listar();
		return new ResponseEntity<List<Envio>>(lista, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Envio> listarPorId(@PathVariable("id") Integer id){
		Envio obj = service.leerPorId(id);
		if(obj.getIdEnvio() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Envio>(obj, HttpStatus.OK); 
	}
	
	@GetMapping(value = "/hateoas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EnvioDTO> listarHateoas() {
		List<Envio> envios = new ArrayList<>();
		List<EnvioDTO> enviosDTO = new ArrayList<>();
		envios = service.listar();
		
		for (Envio e : envios) {
			EnvioDTO d = new EnvioDTO();
			d.setArticulos(e.getArticulos());
			d.setComprador(e.getComprador());
			d.setIdEnvio(e.getIdEnvio());
			d.setImporte(e.getPago().getImporte());
			d.setVendedor(e.getVendedor());
			
			// localhost:8080/consultas/1
			ControllerLinkBuilder linkTo = linkTo(methodOn(ArticuloController.class).listarPorId((e.getIdEnvio())));
			d.add(linkTo.withSelfRel());
			enviosDTO.add(d);
			
			ControllerLinkBuilder linkTo1 = linkTo(methodOn(CompradorController.class).listarPorId((e.getComprador().getIdComprador())));
			d.add(linkTo1.withSelfRel());
			enviosDTO.add(d);
			
			ControllerLinkBuilder linkTo2 = linkTo(methodOn(VendedorController.class).listarPorId((e.getVendedor().getIdVendedor())));
			d.add(linkTo2.withSelfRel());		
			enviosDTO.add(d);
			
			ControllerLinkBuilder linkTo3 = linkTo(methodOn(EnvioController.class).listarPorId((e.getIdEnvio())));
			d.add(linkTo3.withSelfRel());		
			enviosDTO.add(d);
			
			ControllerLinkBuilder linkTo4 = linkTo(methodOn(PagoController.class).listarPorId((e.getPago().getIdPago())));
			d.add(linkTo4.withSelfRel());		
			enviosDTO.add(d);
		}
		return enviosDTO;
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Envio envio) {
		Envio obj = service.registrar(envio);
		//consultas/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdEnvio()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping
	public ResponseEntity<Envio> modificar(@Valid @RequestBody Envio envio) {
		Envio obj = service.modificar(envio);
		return new ResponseEntity<Envio>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Envio obj = service.leerPorId(id);
		if(obj.getIdEnvio() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@PostMapping("/buscar")
	public ResponseEntity<List<Envio>> buscar(@RequestBody FiltroCompraDTO filtro) {
		List<Envio> envios = new ArrayList<>();

		if (filtro != null) {
			if (filtro.getFechaConsulta() != null) {
				envios = service.buscarFecha(filtro);
			} else {
				envios = service.buscar(filtro);
			}
		}
		return new ResponseEntity<List<Envio>>(envios, HttpStatus.OK);
	}
	
	
	
	
	
}

