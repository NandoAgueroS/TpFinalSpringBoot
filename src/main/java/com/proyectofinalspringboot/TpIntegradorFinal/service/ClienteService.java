package com.proyectofinalspringboot.TpIntegradorFinal.service;

import com.proyectofinalspringboot.TpIntegradorFinal.model.Cliente;
import com.proyectofinalspringboot.TpIntegradorFinal.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public void editCliente(Long id_cliente, String nombre_edit, String apellido_edit, String dni_edit) {
        Cliente cliente = this.findCliente(id_cliente);
        cliente.setNombre(nombre_edit);
        cliente.setApellido(apellido_edit);
        cliente.setDni(dni_edit);
        this.saveCliente(cliente);
    }

    @Override
    public List<Cliente> getClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente findCliente(Long id) {
        return clienteRepo.findById(id).orElse(null);
    }
}
