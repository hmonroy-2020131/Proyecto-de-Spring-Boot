package com.eithanmonroy.webapp.biblioteca.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eithanmonroy.webapp.biblioteca.model.Libro;
import com.eithanmonroy.webapp.biblioteca.service.LibroService;

@Controller
@RestController
@RequestMapping("")
@CrossOrigin(value = "http://127.0.0.1:5500")
public class LibroController {
   @Autowired
    LibroService libroService;
 
    @GetMapping("/libros")
    public ResponseEntity<List<Libro>> listarLibros() {
        try {
            return ResponseEntity.ok(libroService.listarLibros());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
 
    @GetMapping("/libro")
    public ResponseEntity <Libro> buscarLibroPorId(@RequestParam long id) {
        try {
            return ResponseEntity.ok(libroService.buscarLibro(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
   
 
    @PostMapping("/libro")
    public ResponseEntity<Map<String,String>> agregarLibro(@RequestBody Libro libro) {
        Map<String,String> response = new HashMap<>();
 
        try {
            libroService.guardarLibro(libro);
            response.put("message", "Se ha creado con exito");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message" ,"error" );
            response.put("err" ,"No se ha agregado el Cliente" );
            return ResponseEntity.badRequest().body(response);
        }
    }
 
    @PutMapping("/libro")
    public ResponseEntity <Map<String, String>> editarLibro(@RequestParam Long id, @RequestBody Libro libroNuevo) {
        Map<String,String> response = new HashMap<>();
        try {
            Libro libro = libroService.buscarLibro(id);
            libro.setAutor(libroNuevo.getAutor());
            libro.setCategoria(libroNuevo.getCategoria());
            libro.setCluster(libroNuevo.getCluster());
            libro.setDisponibilidad(libroNuevo.getDisponibilidad());
            libro.setEditorial(libroNuevo.getEditorial());
            libro.setIsbn(libroNuevo.getIsbn());
            libro.setNombre(libroNuevo.getNombre());
            libro.setNumeroEstanteria(libroNuevo.getNumeroEstanteria());
            libro.setSinopsis(libroNuevo.getSinopsis());
            libroService.guardarLibro(libro);
            response.put("message", "Se he modificado correctamente");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message" ,"error" );
            response.put("err" ,"No se ha modificado con exito" );
            return ResponseEntity.badRequest().body(response);
        }
    }
 
    @DeleteMapping("/libro")
    public ResponseEntity<Map<String, String>> eliminarLibro(@RequestParam Long id){
        Map<String, String> response = new HashMap<>();
        try {
            Libro libro = libroService.buscarLibro(id);
 
            libroService.eliminarLibro(libro);
            response.put("message", "Se ha elimnado con exito");
            return ResponseEntity.ok(response);
 
        } catch (Exception e) {
            response.put("message" ,"error" );
            response.put("err" ,"No se ha eliminado con exito" );
            return ResponseEntity.badRequest().body(response);
        }
    }

}
