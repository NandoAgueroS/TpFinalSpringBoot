package com.proyectofinalspringboot.TpIntegradorFinal.controller;

import com.proyectofinalspringboot.TpIntegradorFinal.model.Cliente;
import com.proyectofinalspringboot.TpIntegradorFinal.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    private IClienteService clienteService;

    //creacion
    @PostMapping("/clientes/crear")
    public void saveCliente(@RequestBody Cliente cliente) {
        clienteService.saveCliente(cliente);
    }

    //lista completa de clientes
    @GetMapping("/clientes")
    @ResponseBody
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    //traer un cliente en particular
    @GetMapping("/clientes/{id_cliente}")
    @ResponseBody
    public Cliente findCliente(@PathVariable Long id_cliente){
        return clienteService.findCliente(id_cliente);
    }
    //eliminacion
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public void deleteCliente(@PathVariable Long id_cliente){
        clienteService.deleteCliente(id_cliente);
    }
    //edicion
    @PutMapping("/clientes/editar/{id_cliente}")
    public void editCliente(@PathVariable Long id_cliente,
                            @RequestParam String nombre_edit,
                            @RequestParam String apellido_edit,
                            @RequestParam String dni_edit){
        clienteService.editCliente(id_cliente, nombre_edit, apellido_edit, dni_edit);
    }

}
