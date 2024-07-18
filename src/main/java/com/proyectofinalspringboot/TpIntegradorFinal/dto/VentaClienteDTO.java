package com.proyectofinalspringboot.TpIntegradorFinal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaClienteDTO {
    private Long codigo_venta;
    private Double monto_total;
    private Integer cantidad_productos;
    private String nombre_cliente;
    private String apellido_cliente;

    public VentaClienteDTO() {
    }

    public VentaClienteDTO(Long codigo_venta, Double monto_total, Integer cantidad_productos,
                           String nombre_cliente, String apellido_cliente) {
        this.codigo_venta = codigo_venta;
        this.monto_total = monto_total;
        this.cantidad_productos = cantidad_productos;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }
}
