package com.springboot.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.model.Repartidor;

@Repository
public interface RepartidorJpaRepository extends CrudRepository<Repartidor, Long>, JpaRepository<Repartidor, Long> {

	@Query("SELECT e FROM Repartidor e WHERE e.estado = :estado ")
	List<Repartidor> buscarRepartidorLibre(@Param("estado") String estado);

}
