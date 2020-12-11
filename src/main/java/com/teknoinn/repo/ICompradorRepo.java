package com.teknoinn.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teknoinn.model.Comprador;

public interface ICompradorRepo extends JpaRepository<Comprador, Integer> {

}
