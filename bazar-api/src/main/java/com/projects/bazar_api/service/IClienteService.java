package com.projects.bazar_api.service;

import com.projects.bazar_api.model.Cliente;
import java.util.List;

public interface IClienteService {
    public Cliente saveCliente(Cliente cliente);

    public List<Cliente> getAllClientes();

    public Cliente getClienteById(Long id);

    public void deleteCliente(Long id);

    public Cliente updateCliente(Long id, Cliente cliente);
}