package com.projects.bazar_api.repository;

import com.projects.bazar_api.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaRepository extends JpaRepository<Venta, Long> {
}