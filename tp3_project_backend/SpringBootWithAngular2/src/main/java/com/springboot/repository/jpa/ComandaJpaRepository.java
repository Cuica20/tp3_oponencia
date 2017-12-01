package com.springboot.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.model.Comanda;

@Repository
public interface ComandaJpaRepository extends CrudRepository<Comanda, Long>, JpaRepository<Comanda,Long>{

	@Query("SELECT v FROM Comanda v WHERE  v.sugerencia = :sugerencia ")
	List<Comanda> findAllPendiente(@Param("sugerencia") String sugerencia);

}
