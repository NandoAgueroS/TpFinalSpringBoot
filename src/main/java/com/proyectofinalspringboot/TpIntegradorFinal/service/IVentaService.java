package com.proyectofinalspringboot.TpIntegradorFinal.service;

import com.proyectofinalspringboot.TpIntegradorFinal.dto.VentaClienteDTO;
import com.proyectofinalspringboot.TpIntegradorFinal.model.Producto;
import com.proyectofinalspringboot.TpIntegradorFinal.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    public void saveVenta(Venta venta);

    public void deleteVenta(Long id);

    public void editVenta(Long codigo_venta, Venta venta);

    public List<Venta> getVentas();

    public Venta findVenta(Long id);

    List<Producto> getProductosPorVenta(Long codigoVenta);

    String ventasDeUnaFecha(LocalDate fechaVenta);

    VentaClienteDTO getMayorVenta();
}
