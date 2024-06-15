package com.projects.bazar_api.controller;

import com.projects.bazar_api.model.Producto;
import com.projects.bazar_api.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private IProductoService productoService;

    @PostMapping("/crear")
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/{codigo_producto}")
    public Producto getProductoById(@PathVariable Long codigo_producto) {
        return productoService.getProductoById(codigo_producto);
    }

    @DeleteMapping("/eliminar/{codigo_producto}")
    public void deleteProducto(@PathVariable Long codigo_producto) {
        productoService.deleteProducto(codigo_producto);
    }

    @PutMapping("/editar/{codigo_producto}")
    public Producto updateProducto(@PathVariable Long codigo_producto, @RequestBody Producto producto) {
        return productoService.updateProducto(codigo_producto, producto);
    }

    @GetMapping("/falta_stock")
    public List<Producto> getProductosWithLowStock() {
        return productoService.getProductosWithLowStock();
    }
}