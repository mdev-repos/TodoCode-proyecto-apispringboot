package com.projects.bazar_api.service;

import com.projects.bazar_api.model.Producto;
import com.projects.bazar_api.model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    public Venta saveVenta(Venta venta);

    public List<Venta> getAllVentas();

    public Venta getVentaById(Long id);

    public void deleteVenta(Long id);

    public Venta updateVenta(Long id, Venta venta);

    public List<Producto> getProductosByVentaId(Long id);

    public Double getSumTotalVentasByFecha(LocalDate fecha);

    public Long getCantidadTotalVentasByFecha(LocalDate fecha);

    public Venta getVentaConMayorMonto();
}