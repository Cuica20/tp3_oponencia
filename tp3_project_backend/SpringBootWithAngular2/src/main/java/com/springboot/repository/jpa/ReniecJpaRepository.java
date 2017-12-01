package com.springboot.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Reniec;

@Repository
public interface ReniecJpaRepository extends CrudRepository<Reniec, Long>, JpaRepository<Reniec, Long> {

}
