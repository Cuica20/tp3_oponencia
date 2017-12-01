package com.springboot.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.PromocionPago;

@Repository
public interface PromocionPagoJpaRepository extends CrudRepository<PromocionPago, Long>, JpaRepository<PromocionPago,Long>{

}
