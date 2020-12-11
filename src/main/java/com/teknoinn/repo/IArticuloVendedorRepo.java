package com.teknoinn.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.teknoinn.model.ArticuloVendedor;


public interface IArticuloVendedorRepo extends JpaRepository<ArticuloVendedor,Integer> {
	
	@Modifying
	@Query(value = "INSERT INTO articulo_vendedor(id_articulo, id_vendedor) VALUES (:idArticulo, :idVendedor)", nativeQuery = true)
	Integer registrar(@Param("idArticulo") Integer idArticulo, @Param("idVendedor") Integer idVendedor);
	
	@Query("from ArticuloVendedor av where av.vendedor.idVendedor = :idVendedor")
	List<ArticuloVendedor> listarArticulosPorVendedor(@Param("idVendedor") Integer idVendedor);

}
