package com.eithanmonroy.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eithanmonroy.webapp.biblioteca.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
