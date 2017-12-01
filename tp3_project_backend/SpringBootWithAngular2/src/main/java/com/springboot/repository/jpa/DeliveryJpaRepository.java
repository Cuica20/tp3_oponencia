package com.springboot.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.model.Entrega;

@Repository
public interface DeliveryJpaRepository extends CrudRepository<Entrega, Long>, JpaRepository<Entrega, Long> {
	
	@Query("SELECT e FROM Entrega e WHERE e.estado = :estado")
	List<Entrega> buscarDeliverysPorEstado(@Param("estado") String estado);

}
