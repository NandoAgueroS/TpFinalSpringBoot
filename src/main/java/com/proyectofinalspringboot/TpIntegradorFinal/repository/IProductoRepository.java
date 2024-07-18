package com.proyectofinalspringboot.TpIntegradorFinal.repository;

import com.proyectofinalspringboot.TpIntegradorFinal.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
