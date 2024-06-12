package com.todocode.api_springboot.repository;

import com.todocode.api_springboot.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
