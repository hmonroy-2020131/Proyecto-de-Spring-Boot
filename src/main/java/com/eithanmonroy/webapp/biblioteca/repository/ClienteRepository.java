package com.eithanmonroy.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eithanmonroy.webapp.biblioteca.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
