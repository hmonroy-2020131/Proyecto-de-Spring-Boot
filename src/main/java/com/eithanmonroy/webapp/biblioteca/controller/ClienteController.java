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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eithanmonroy.webapp.biblioteca.model.Cliente;
import com.eithanmonroy.webapp.biblioteca.service.ClienteService;

@Controller
@RestController
@RequestMapping("")
@CrossOrigin(value = "http://127.0.0.1:5500")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> listarClientes(){
        return clienteService.listarClientes();
            
    }

    @GetMapping("/cliente")
    public ResponseEntity<Cliente> buscarClientePorDpi(@PathVariable Long dpi){
        try {
            Cliente cliente = clienteService.buscarClientePorDpi(dpi);
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
            // TODO: handle exception
        }
    }

    @PostMapping("/cliente")
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

    @PutMapping("/cliente")
    public ResponseEntity <Map<String, String>> editarCliente(@RequestParam Long dpi, @RequestBody Cliente clienteNuevo) {
        Map<String,String> response = new HashMap<>();
        try {
            Cliente cliente = clienteService.buscarClientePorDpi(dpi);
            cliente.setNombre(clienteNuevo.getNombre());
            cliente.setApellido(clienteNuevo.getApellido());
            cliente.setTelefono(clienteNuevo.getTelefono());
            clienteService.guardarCliente(cliente);
            response.put("message", "Se he modificado correctamente");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message" ,"error" );
            response.put("err" ,"No se ha modificado con exito" );
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @DeleteMapping("/cliente")
    public ResponseEntity<Map<String, String>> eliminarCliente(@RequestParam Long dpi){
        Map<String, String> response = new HashMap<>();
        try {
            Cliente cliente = clienteService.buscarClientePorDpi(dpi);
 
            clienteService.eliminarCliente(cliente);
            response.put("message", "Se ha elimnado con exito");
            return ResponseEntity.ok(response);
 
        } catch (Exception e) {
            response.put("message" ,"error" );
            response.put("err" ,"No se ha eliminado con exito" );
            return ResponseEntity.badRequest().body(response);
        }
    }

}
