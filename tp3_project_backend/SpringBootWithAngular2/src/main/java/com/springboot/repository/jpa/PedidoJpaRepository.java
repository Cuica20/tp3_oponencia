package com.springboot.repository.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.model.Pedido;

@Repository
public interface PedidoJpaRepository extends CrudRepository<Pedido, Long>, JpaRepository<Pedido,Long>{

	@Query("SELECT e FROM Pedido e WHERE e.estado = :estado AND DATE(e.fecha) = :fecha")
	List<Pedido> findPedidoPendiente(@Param("estado") String estado,@Param("fecha") Date fecha);

}
