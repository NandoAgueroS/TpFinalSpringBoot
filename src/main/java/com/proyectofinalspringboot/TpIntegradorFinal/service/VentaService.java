package com.proyectofinalspringboot.TpIntegradorFinal.service;

import com.proyectofinalspringboot.TpIntegradorFinal.dto.VentaClienteDTO;
import com.proyectofinalspringboot.TpIntegradorFinal.model.Producto;
import com.proyectofinalspringboot.TpIntegradorFinal.model.Venta;
import com.proyectofinalspringboot.TpIntegradorFinal.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService implements IVentaService {
    @Autowired
    private IVentaRepository ventaRepo;

    @Override
    public void saveVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public void editVenta(Long codigo_venta, Venta venta) {
        venta.setCodigo_venta(codigo_venta);
        ventaRepo.save(venta);
    }

    @Override
    public List<Venta> getVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public Venta findVenta(Long id) {
        return ventaRepo.findById(id).orElse(null);
    }

    @Override
    public List<Producto> getProductosPorVenta(Long codigoVenta) {
        Venta venta = this.findVenta(codigoVenta);
        List<Producto> productosDeLaVenta = venta.getListaProductos();
        return productosDeLaVenta;
    }

    @Override
    public String ventasDeUnaFecha(LocalDate fechaVenta) {
        List<Venta> listaVentas = this.getVentas();
        Double montoTotal = 0.0;
        Integer cantidadVentas = 0;

        for (Venta ventaActual : listaVentas) {
            if (ventaActual.getFecha_venta().equals(fechaVenta)) {
                montoTotal += ventaActual.getTotal();
                cantidadVentas++;
            }
        }
        return "Detalles del día " + fechaVenta.toString()
                + ", Monto total: " + montoTotal
                + " Cantidad de ventas: " + cantidadVentas;
    }

    @Override
    public VentaClienteDTO getMayorVenta() {
        List<Venta> listaVentas = this.getVentas();
        Venta ventaMayor = null;
        for (Venta ventaActual : listaVentas){
            if (ventaMayor==null){
                ventaMayor = ventaActual;
            }else if (ventaActual.getTotal()>ventaMayor.getTotal()){
                ventaMayor = ventaActual;
            }
        }
        VentaClienteDTO ventaMayorDTO = new VentaClienteDTO();
        ventaMayorDTO.setCodigo_venta(ventaMayor.getCodigo_venta());
        ventaMayorDTO.setMonto_total(ventaMayor.getTotal());
        ventaMayorDTO.setCantidad_productos(ventaMayor.getListaProductos().size());
        ventaMayorDTO.setNombre_cliente(ventaMayor.getUnCliente().getNombre());
        ventaMayorDTO.setApellido_cliente(ventaMayor.getUnCliente().getApellido());
        return ventaMayorDTO;
    }
}
