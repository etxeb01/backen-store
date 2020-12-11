package com.teknoinn.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teknoinn.model.Articulo;

public interface IArticuloRepo extends JpaRepository<Articulo, Integer> {

}
