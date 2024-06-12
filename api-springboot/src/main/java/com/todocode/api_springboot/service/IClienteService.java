package com.todocode.api_springboot.service;

import com.todocode.api_springboot.model.Cliente;

import java.util.List;

public interface IClienteService {
    public Cliente saveCliente(Cliente cliente);

    public List<Cliente> getAllClientes();

    public Cliente getClienteById(Long id);

    public void deleteCliente(Long id);

    public Cliente updateCliente(Long id, Cliente cliente);
}
