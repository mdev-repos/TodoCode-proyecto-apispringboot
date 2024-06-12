package com.todocode.api_springboot.controller;

import com.todocode.api_springboot.model.Cliente;
import com.todocode.api_springboot.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private IClienteService clienteService;

    @PostMapping("/crear")
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id_cliente}")
    public Cliente getClienteById(@PathVariable Long id_cliente) {
        return clienteService.getClienteById(id_cliente);
    }

    @DeleteMapping("/eliminar/{id_cliente}")
    public void deleteCliente(@PathVariable Long id_cliente) {
        clienteService.deleteCliente(id_cliente);
    }

    @PutMapping("/editar/{id_cliente}")
    public Cliente updateCliente(@PathVariable Long id_cliente, @RequestBody Cliente cliente) {
        return clienteService.updateCliente(id_cliente, cliente);
    }
}