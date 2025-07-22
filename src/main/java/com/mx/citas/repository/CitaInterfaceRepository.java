package com.mx.citas.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.citas.model.Cita;


public interface CitaInterfaceRepository extends JpaRepository<Cita, Integer> {

    Cita findByFecha(Date fecha);
}
