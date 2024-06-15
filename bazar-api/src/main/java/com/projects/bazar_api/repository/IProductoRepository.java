package com.projects.bazar_api.repository;

import com.projects.bazar_api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
}