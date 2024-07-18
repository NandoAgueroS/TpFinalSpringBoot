package com.proyectofinalspringboot.TpIntegradorFinal.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente unCliente;

    @ManyToMany
    @JoinTable(name="lista_de_productos",
            joinColumns = @JoinColumn(name="fk_venta", nullable = false),
            inverseJoinColumns = @JoinColumn(name="fk_producto", nullable = false))
    private List<Producto> listaProductos;

    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, Double total, Cliente unCliente, List<Producto> listaProductos) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.unCliente = unCliente;
        this.listaProductos = listaProductos;
    }
}
