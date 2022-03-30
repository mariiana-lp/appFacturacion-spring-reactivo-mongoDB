package com.example.API_ferreteria.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection ="inventario" )
public class InventarioDTOReactivo {
    @Id
    private String id = UUID.randomUUID().toString().substring(0,10);
    private String idProducto;
    private int cantidadActual;
    private int minimo;
    private int maximo;

    public InventarioDTOReactivo(String id, String idProducto, int cantidadActual, int minimo, int maximo) {
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

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }
}
