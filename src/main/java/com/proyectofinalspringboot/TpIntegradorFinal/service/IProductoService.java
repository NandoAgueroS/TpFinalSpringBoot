package com.proyectofinalspringboot.TpIntegradorFinal.service;

import com.proyectofinalspringboot.TpIntegradorFinal.model.Producto;
import com.proyectofinalspringboot.TpIntegradorFinal.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IProductoService {

    public void saveProducto(Producto producto);

    public void deleteProducto(Long id);

    public void editProducto(Long codigo_producto, String nombre_edit, String marca_edit,
                             Double costo_edit, Double cantidad_disponible_edit);

    public List<Producto> getProductos();

    public Producto findProducto(Long id);

    public List<Producto> getStockMenorA5();
}
