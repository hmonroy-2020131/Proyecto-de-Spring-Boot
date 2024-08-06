package com.eithanmonroy.webapp.biblioteca.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eithanmonroy.webapp.biblioteca.model.Cliente;
import com.eithanmonroy.webapp.biblioteca.service.ClienteService;

@Controller
@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/")
    public List<Cliente> listarClientes(){
        return clienteService.listarClientes();
            
    }

    @GetMapping("/id = {id}")
    public ResponseEntity<Cliente> buscarClientePorDpi(@PathVariable Long dpi){
        try {
            Cliente cliente = clienteService.buscarClientePorDpi(dpi);
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
            // TODO: handle exception
        }
    }

    @PostMapping("/")
    public ResponseEntity<Map<String, String>> agregarCliente(@RequestBody Cliente cliente){
        Map<String, String> response = new HashMap<>();
        try {
            clienteService.guardarCliente(cliente);
            response.put("message", "Cliente creado con exito");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("Err", "Hubo un error al crear la categoria");
            return ResponseEntity.badRequest().body(response);
            // TODO: handle exception
        }
    }

    

}
