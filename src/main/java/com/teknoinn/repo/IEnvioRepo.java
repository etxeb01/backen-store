package com.teknoinn.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.teknoinn.model.Envio;


public interface IEnvioRepo extends JpaRepository<Envio, Integer> {
	
	
	@Query("from Envio e where e.comprador.dni = :dni or LOWER(e.comprador.nombres) like %:nombreCompleto% or LOWER(e.comprador.apellidos) like %:nombreCompleto%")
	List<Envio> buscar(@Param("dni")String dni,@Param("nombreCompleto") String nombreCompleto);

	// >= <
	@Query("from Envio e where e.fechaEnvio between :fechaEnvio and :fechaSgte")
	List<Envio> buscarFecha(@Param("fechaEnvio") LocalDateTime fechaEnvio, @Param("fechaSgte") LocalDateTime fechaSgte);

	
	


}
