package com.teknoinn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.teknoinn.model.Comprador;


public interface ICompradorService extends ICRUD<Comprador> {

	
	Page<Comprador> listarPageable(Pageable pageable);
}
