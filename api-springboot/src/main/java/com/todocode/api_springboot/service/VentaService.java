package com.todocode.api_springboot.service;

import com.todocode.api_springboot.model.Producto;
import com.todocode.api_springboot.model.Venta;
import java.time.LocalDate;
import com.todocode.api_springboot.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {
    @Autowired
    private IVentaRepository ventaRepository;

    @Override
    public Venta saveVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta getVentaById(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepository.deleteById(id);
    }

    @Override
    public Venta updateVenta(Long id, Venta venta) {
        Venta existingVenta = ventaRepository.findById(id).orElse(null);
        if (existingVenta != null) {
            existingVenta.setFecha_venta(venta.getFecha_venta());
            existingVenta.setTotal(venta.getTotal());
            existingVenta.setListaProductos(venta.getListaProductos());
            existingVenta.setUnCliente(venta.getUnCliente());
            return ventaRepository.save(existingVenta);
        }
        return null;
    }

    @Override
    public List<Producto> getProductosByVentaId(Long id) {
        Venta venta = ventaRepository.findById(id).orElse(null);
        return (venta != null) ? venta.getListaProductos() : null;
    }

    @Override
    public Double getSumTotalVentasByFecha(LocalDate fecha) {
        return ventaRepository.findAll().stream()
                .filter(venta -> venta.getFecha_venta().isEqual(fecha))
                .mapToDouble(Venta::getTotal)
                .sum();
    }

    @Override
    public Long getCantidadTotalVentasByFecha(LocalDate fecha) {
        return ventaRepository.findAll().stream()
                .filter(venta -> venta.getFecha_venta().isEqual(fecha))
                .count();
    }

    @Override
    public Venta getVentaConMayorMonto() {
        return ventaRepository.findAll().stream()
                .max((v1, v2) -> v1.getTotal().compareTo(v2.getTotal()))
                .orElse(null);
    }
}