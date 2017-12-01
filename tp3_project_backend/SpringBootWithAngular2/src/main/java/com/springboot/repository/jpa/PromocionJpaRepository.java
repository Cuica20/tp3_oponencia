package com.springboot.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Promocion;

@Repository
public interface PromocionJpaRepository extends CrudRepository<Promocion, Long>, JpaRepository<Promocion,Long>{

}
