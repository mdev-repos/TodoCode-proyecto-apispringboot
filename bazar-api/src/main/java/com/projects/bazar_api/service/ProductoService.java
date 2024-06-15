package com.projects.bazar_api.service;

import com.projects.bazar_api.model.Producto;
import com.projects.bazar_api.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto getProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Producto updateProducto(Long id, Producto producto) {
        Producto existingProducto = productoRepository.findById(id).orElse(null);
        if (existingProducto != null) {
            existingProducto.setNombre(producto.getNombre());
            existingProducto.setMarca(producto.getMarca());
            existingProducto.setCosto(producto.getCosto());
            existingProducto.setCantidad_disponible(producto.getCantidad_disponible());
            return productoRepository.save(existingProducto);
        }
        return null;
    }

    @Override
    public List<Producto> getProductosWithLowStock() {
        return productoRepository.findAll().stream()
                .filter(producto -> producto.getCantidad_disponible() < 5)
                .toList();
    }
}