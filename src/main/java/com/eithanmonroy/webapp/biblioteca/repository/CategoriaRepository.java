package com.eithanmonroy.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eithanmonroy.webapp.biblioteca.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
