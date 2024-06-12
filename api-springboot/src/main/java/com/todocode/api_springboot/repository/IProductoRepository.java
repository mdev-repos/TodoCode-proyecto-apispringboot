package com.todocode.api_springboot.repository;

import com.todocode.api_springboot.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
