package com.springboot.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Reparto;

@Repository
public interface RepartoJpaRepository extends CrudRepository<Reparto, Long>, JpaRepository<Reparto,Long>{

}
