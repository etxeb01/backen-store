package com.teknoinn.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teknoinn.model.Pago;

public interface IPagoRepo extends JpaRepository<Pago, Integer> {

}
