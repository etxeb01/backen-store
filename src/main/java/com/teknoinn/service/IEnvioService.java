package com.teknoinn.service;

import java.util.List;

import com.teknoinn.dto.FiltroCompraDTO;
import com.teknoinn.model.Envio;

public interface IEnvioService extends ICRUD<Envio> {

		
	List<Envio> buscar(FiltroCompraDTO filtro);
	
	List<Envio> buscarFecha(FiltroCompraDTO filtro);
	
	
	
}
