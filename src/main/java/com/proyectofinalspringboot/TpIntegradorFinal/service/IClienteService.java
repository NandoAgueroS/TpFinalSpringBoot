package com.proyectofinalspringboot.TpIntegradorFinal.service;

import com.proyectofinalspringboot.TpIntegradorFinal.model.Cliente;
import com.proyectofinalspringboot.TpIntegradorFinal.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IClienteService {
    public void saveCliente(Cliente cliente);

    public void deleteCliente(Long id);

    public void editCliente(Long id_cliente, String nombre_edit,
                            String apellido_edit, String dni_edit);

    public List<Cliente> getClientes();

    public Cliente findCliente(Long id);

}
