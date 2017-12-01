package com.springboot.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.PedidoProyectado;

@Repository
public interface PedidoProyectadoJpaRepository extends CrudRepository<PedidoProyectado, Long>, JpaRepository<PedidoProyectado,Long>{

}
