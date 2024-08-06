package com.eithanmonroy.webapp.biblioteca.service;

import java.util.List;

import com.eithanmonroy.webapp.biblioteca.model.Cliente;

public interface IClienteService {

    public List<Cliente> listarClientes();

    public void guardarCliente(Cliente cliente);

    public Cliente buscarClientePorDpi(Long dpi);

    public void eliminarCliente (Cliente cliente);

}
