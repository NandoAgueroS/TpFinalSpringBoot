package com.proyectofinalspringboot.TpIntegradorFinal.controller;

import com.proyectofinalspringboot.TpIntegradorFinal.model.Producto;
import com.proyectofinalspringboot.TpIntegradorFinal.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @PostMapping("/productos/crear")
    public void saveProducto(@RequestBody Producto producto) {
        productoService.saveProducto(producto);
    }

    @GetMapping("/productos")
    @ResponseBody
    public List<Producto> getProductos() {
        return productoService.getProductos();
    }

    @GetMapping("/productos/{codigo_producto}")
    @ResponseBody
    public Producto findProducto(@PathVariable Long codigo_producto) {
        return productoService.findProducto(codigo_producto);
    }

    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public void deleteProducto(@PathVariable Long codigo_producto) {
        productoService.deleteProducto(codigo_producto);
    }

    @PutMapping("/productos/editar/{codigo_producto}")
    public void editProducto(@PathVariable Long codigo_producto,
                             @RequestParam String nombre_edit,
                             @RequestParam String marca_edit,
                             @RequestParam Double costo_edit,
                             @RequestParam Double cantidad_disponible_edit) {
        productoService.editProducto(codigo_producto, nombre_edit, marca_edit, costo_edit, cantidad_disponible_edit);
    }

    //productos con cantidad_disponible menor a 5
    @GetMapping("/productos/falta_stock")
    public List<Producto> getStockMenorA5(){
        return productoService.getStockMenorA5();
    }
}
