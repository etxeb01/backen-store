package com.teknoinn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teknoinn.model.Pago;
import com.teknoinn.repo.IPagoRepo;
import com.teknoinn.service.IPagoService;

@Service
public class PagoServiceImpl implements IPagoService{

	@Autowired
	private IPagoRepo repo;
		
	@Override
	public Pago registrar(Pago obj) {
		return repo.save(obj);
	}

	@Override
	public Pago modificar(Pago obj) {
		return repo.save(obj);
	}

	@Override
	public List<Pago> listar() {
		return repo.findAll();
	}

	@Override
	public Pago leerPorId(Integer id) {
		Optional<Pago> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Pago();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
