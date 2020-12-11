package com.teknoinn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.teknoinn.model.Comprador;
import com.teknoinn.repo.ICompradorRepo;
import com.teknoinn.service.ICompradorService;

@Service
public class CompradorServiceImpl implements ICompradorService {

	@Autowired
	private ICompradorRepo repo;
	
	@Override
	public Comprador registrar(Comprador obj) {
		return repo.save(obj);
	}

	@Override
	public Comprador modificar(Comprador obj) {
		return repo.save(obj);
	}

	@Override
	public List<Comprador> listar() {
		return repo.findAll();
	}

	@Override
	public Comprador leerPorId(Integer id) {
		Optional<Comprador> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Comprador();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public Page<Comprador> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}

}
