package com.projects.bazar_api.service;

import com.projects.bazar_api.model.Producto;
import java.util.List;

public interface IProductoService {

    public Producto saveProducto(Producto producto);

    public List<Producto> getAllProductos();

    public Producto getProductoById(Long id);

    public void deleteProducto(Long id);

    public Producto updateProducto(Long id, Producto producto);

    public List<Producto> getProductosWithLowStock();
}