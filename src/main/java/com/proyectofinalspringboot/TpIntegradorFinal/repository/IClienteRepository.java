package com.proyectofinalspringboot.TpIntegradorFinal.repository;

import com.proyectofinalspringboot.TpIntegradorFinal.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends
        JpaRepository<Cliente, Long> {
}
