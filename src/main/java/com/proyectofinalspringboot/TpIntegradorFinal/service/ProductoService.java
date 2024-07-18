package com.proyectofinalspringboot.TpIntegradorFinal.service;

import com.proyectofinalspringboot.TpIntegradorFinal.model.Producto;
import com.proyectofinalspringboot.TpIntegradorFinal.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepo;

    @Override
    public void saveProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepo.deleteById(id);
    }

    @Override
    public void editProducto(Long codigo_producto, String nombre_edit, String marca_edit, Double costo_edit, Double cantidad_disponible_edit) {
        Producto producto = this.findProducto(codigo_producto);
        producto.setNombre(nombre_edit);
        producto.setMarca(marca_edit);
        producto.setCosto(costo_edit);
        producto.setCantidad_disponible(cantidad_disponible_edit);

        this.saveProducto(producto);
    }

    @Override
    public List<Producto> getProductos() {
        return productoRepo.findAll();
    }

    @Override
    public Producto findProducto(Long id) {
        return productoRepo.findById(id).orElse(null);
    }

    @Override
    public List<Producto> getStockMenorA5() {
        List<Producto> listaProductos = this.getProductos();
        List<Producto> pocoStock = new ArrayList<Producto>();
        for (Producto productoActual : listaProductos) {
            System.out.println("---------------");
            System.out.println("Nombre del producto: " + productoActual.getNombre() + " Marca: " + productoActual.getMarca());
            System.out.println("Stock: " + productoActual.getCantidad_disponible());
            if (productoActual.getCantidad_disponible()<5){
                pocoStock.add(productoActual);
            }
        }
        return pocoStock;
    }
}
