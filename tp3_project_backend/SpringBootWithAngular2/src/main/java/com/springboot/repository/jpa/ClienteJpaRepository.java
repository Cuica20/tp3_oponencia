package com.springboot.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Cliente;

@Repository
public interface ClienteJpaRepository extends CrudRepository<Cliente, Long>, JpaRepository<Cliente,Long>{

}