package com.teknoinn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teknoinn.model.Articulo;
import com.teknoinn.repo.IArticuloRepo;
import com.teknoinn.service.IArticuloService;



@Service
public class ArticuloServiceImpl implements IArticuloService {
	
	@Autowired
	private IArticuloRepo repo;
	
	@Override
	public Articulo registrar(Articulo obj) {
		return repo.save(obj);
	}

	@Override
	public Articulo modificar(Articulo obj) {
		return repo.save(obj);
	}

	@Override
	public List<Articulo> listar() {
		return repo.findAll();
	}

	@Override
	public Articulo leerPorId(Integer id) {
		Optional<Articulo> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Articulo();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

	



	

}
