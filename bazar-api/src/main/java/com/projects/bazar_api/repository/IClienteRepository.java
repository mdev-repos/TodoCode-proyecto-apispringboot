package com.projects.bazar_api.repository;

import com.projects.bazar_api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}