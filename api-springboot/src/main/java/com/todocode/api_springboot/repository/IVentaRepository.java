package com.todocode.api_springboot.repository;

import com.todocode.api_springboot.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaRepository extends JpaRepository<Venta, Long> {
}
