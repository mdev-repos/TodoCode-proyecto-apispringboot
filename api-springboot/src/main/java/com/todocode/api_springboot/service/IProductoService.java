package com.todocode.api_springboot.service;

import com.todocode.api_springboot.model.Producto;

import java.util.List;

public interface IProductoService {

    public Producto saveProducto(Producto producto);

    public List<Producto> getAllProductos();

    public Producto getProductoById(Long id);

    public void deleteProducto(Long id);

    public Producto updateProducto(Long id, Producto producto);

    public List<Producto> getProductosWithLowStock();
}