package com.eithanmonroy.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eithanmonroy.webapp.biblioteca.model.Prestamo;

public interface PrestamoRepository  extends JpaRepository<Prestamo, Long>{


}
