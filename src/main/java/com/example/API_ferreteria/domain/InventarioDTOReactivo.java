package com.example.API_ferreteria.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection ="inventario" )
public class InventarioDTOReactivo {
    @Id
    private String id = UUID.randomUUID().toString().substring(0,10);
    private String idProducto;
    private Integer cantidadActual;
    private Integer minimo;
    private Integer maximo;

    public InventarioDTOReactivo(String id, String idProducto, Integer cantidadActual, Integer minimo, Integer maximo) {
        this.id = id;
        this.idProducto = idProducto;
        this.cantidadActual = cantidadActual;
        this.minimo = minimo;
        this.maximo = maximo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(Integer cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public Integer getMinimo() {
        return minimo;
    }

    public void setMinimo(Integer minimo) {
        this.minimo = minimo;
    }

    public Integer getMaximo() {
        return maximo;
    }

    public void setMaximo(Integer maximo) {
        this.maximo = maximo;
    }
}
