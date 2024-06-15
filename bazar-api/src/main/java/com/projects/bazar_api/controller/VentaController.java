package com.projects.bazar_api.controller;

import com.projects.bazar_api.model.Producto;
import com.projects.bazar_api.model.Venta;
import com.projects.bazar_api.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    @Autowired
    private IVentaService ventaService;

    @PostMapping("/crear")
    public Venta createVenta(@RequestBody Venta venta) {
        return ventaService.saveVenta(venta);
    }

    @GetMapping
    public List<Venta> getAllVentas() {
        return ventaService.getAllVentas();
    }

    @GetMapping("/{codigo_venta}")
    public Venta getVentaById(@PathVariable Long codigo_venta) {
        return ventaService.getVentaById(codigo_venta);
    }

    @DeleteMapping("/eliminar/{codigo_venta}")
    public void deleteVenta(@PathVariable Long codigo_venta) {
        ventaService.deleteVenta(codigo_venta);
    }

    @PutMapping("/editar/{codigo_venta}")
    public Venta updateVenta(@PathVariable Long codigo_venta, @RequestBody Venta venta) {
        return ventaService.updateVenta(codigo_venta, venta);
    }

    @GetMapping("/productos/{codigo_venta}")
    public List<Producto> getProductosByVentaId(@PathVariable Long codigo_venta) {
        return ventaService.getProductosByVentaId(codigo_venta);
    }

    @GetMapping("/fecha/{fecha_venta}")
    public Double getSumTotalVentasByFecha(@PathVariable String fecha_venta) {
        LocalDate fecha = LocalDate.parse(fecha_venta);
        return ventaService.getSumTotalVentasByFecha(fecha);
    }

    @GetMapping("/cantidad/{fecha_venta}")
    public Long getCantidadTotalVentasByFecha(@PathVariable String fecha_venta) {
        LocalDate fecha = LocalDate.parse(fecha_venta);
        return ventaService.getCantidadTotalVentasByFecha(fecha);
    }

    @GetMapping("/mayor_venta")
    public Venta getVentaConMayorMonto() {
        return ventaService.getVentaConMayorMonto();
    }
}