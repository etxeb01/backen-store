package com.teknoinn.service;

import java.util.List;

import com.teknoinn.model.Menu;

public interface IMenuService extends ICRUD<Menu> {
	
	List<Menu> listarMenuPorUsuario(String nombre);

}
