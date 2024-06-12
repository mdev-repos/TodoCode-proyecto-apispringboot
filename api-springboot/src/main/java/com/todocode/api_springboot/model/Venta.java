package com.todocode.api_springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;

    @ManyToOne
    private Cliente unCliente;

    @ManyToMany
    private List<Producto> listaProductos;

    public Venta(){}
}
