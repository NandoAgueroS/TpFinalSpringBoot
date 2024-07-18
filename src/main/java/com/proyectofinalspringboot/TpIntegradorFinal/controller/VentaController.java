package com.proyectofinalspringboot.TpIntegradorFinal.controller;

import com.proyectofinalspringboot.TpIntegradorFinal.dto.VentaClienteDTO;
import com.proyectofinalspringboot.TpIntegradorFinal.model.Producto;
import com.proyectofinalspringboot.TpIntegradorFinal.model.Venta;
import com.proyectofinalspringboot.TpIntegradorFinal.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VentaController {
    @Autowired
    private IVentaService ventaService;

    //creacion
    @PostMapping("/ventas/crear")
    public void saveVenta(@RequestBody Venta venta){
        ventaService.saveVenta(venta);
    }

    //lista completa de ventas realizadas
    @GetMapping("/ventas")
    @ResponseBody
    public List<Venta> getVentas(){
        return ventaService.getVentas();
    }

    //traer una venta en particular
    @GetMapping("/ventas/{codigo_venta}")
    @ResponseBody
    public Venta findVenta(@PathVariable Long codigo_venta){
        return ventaService.findVenta(codigo_venta);
    }

    //eliminacion
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public void deleteVenta(@PathVariable Long codigo_venta){
        ventaService.deleteVenta(codigo_venta);
    }

    //edicion
    @PutMapping("/ventas/editar/{codigo_venta}")
    public void editVenta(@PathVariable Long codigo_venta, @RequestBody Venta venta){
        ventaService.editVenta(codigo_venta, venta);
    }

    //productos de una determinada venta
    @GetMapping("/ventas/productos/{codigo_venta}")
    @ResponseBody
    public List<Producto> getProductosPorVenta(@PathVariable Long codigo_venta){
        return ventaService.getProductosPorVenta(codigo_venta);
    }

    //monto total y cantidad de ventas de un determinado dia
    @GetMapping("/ventas/fecha/{fecha_venta}")
    @ResponseBody
    public String ventasDeUnaFecha(@PathVariable LocalDate fecha_venta){
        return ventaService.ventasDeUnaFecha(fecha_venta);
    }

    //obtener venta con mayor monto (dto)
    @GetMapping("/ventas/mayor_venta")
    public VentaClienteDTO getMayorVenta(){
        return ventaService.getMayorVenta();
    }
}
