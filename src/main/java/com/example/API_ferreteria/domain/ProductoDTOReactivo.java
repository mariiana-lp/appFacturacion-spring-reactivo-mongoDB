package com.example.API_ferreteria.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "productos")
public class ProductoDTOReactivo {
    @Id
    private String id = UUID.randomUUID().toString().substring(0,10);
    private String nombreProducto;
    private int precioUnidad;

    public ProductoDTOReactivo(String id, String nombreProducto, int precioUnidad) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precioUnidad = precioUnidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(int precioUnidad) {
        this.precioUnidad = precioUnidad;
    }
}
