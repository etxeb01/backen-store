package com.teknoinn.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.teknoinn.dto.FiltroCompraDTO;
import com.teknoinn.model.Envio;
import com.teknoinn.repo.IEnvioRepo;
import com.teknoinn.service.IEnvioService;



@Service
public class EnvioServiceImpl implements IEnvioService{

	@Autowired
	private IEnvioRepo repo;
	
	@Override
	public Envio registrar(Envio obj) {
		return repo.save(obj);
	}

	@Override
	public Envio modificar(Envio obj) {
		return repo.save(obj);
	}

	@Override
	public List<Envio> listar() {
		return repo.findAll();
	}

	@Override
	public Envio leerPorId(Integer id) {
		Optional<Envio> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Envio();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}


	@Override
	public List<Envio> buscar(FiltroCompraDTO filtro) {
		return repo.buscar(filtro.getDni(), filtro.getNombreCompleto());
	}

	@Override
	public List<Envio> buscarFecha(FiltroCompraDTO filtro) {
		LocalDateTime fechaSgte = filtro.getFechaConsulta().plusDays(1);
		return repo.buscarFecha(filtro.getFechaConsulta(), fechaSgte);
	}

	




	
	
}
