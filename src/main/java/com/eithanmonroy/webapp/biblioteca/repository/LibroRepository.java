package com.eithanmonroy.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eithanmonroy.webapp.biblioteca.model.Libro;

public interface LibroRepository extends JpaRepository <Libro, Long> {

}
