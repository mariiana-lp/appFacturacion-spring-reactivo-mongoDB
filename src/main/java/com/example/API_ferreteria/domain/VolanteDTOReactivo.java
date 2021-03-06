package com.example.API_ferreteria.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Document(collection = "volantes")
public class VolanteDTOReactivo {
    @Id
    private String id = UUID.randomUUID().toString().substring(0,10);
    private String nombreProveedor;
    private String documentoIdentidadProveedor;
    @DBRef
    private List<ProductoDTOReactivo> productos;
    private LocalDate fecha;

    public VolanteDTOReactivo(){

    }
    public VolanteDTOReactivo(String id, String nombreProveedor, String documentoIdentidadProveedor, List<ProductoDTOReactivo> productos, LocalDate fecha) {
        this.id = id;
        this.nombreProveedor = nombreProveedor;
        this.documentoIdentidadProveedor = documentoIdentidadProveedor;
        this.productos = productos;
        this.fecha = LocalDate.now();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getDocumentoIdentidadProveedor() {
        return documentoIdentidadProveedor;
    }

    public void setDocumentoIdentidadProveedor(String documentoIdentidadProveedor) {
        this.documentoIdentidadProveedor = documentoIdentidadProveedor;
    }

    public List<ProductoDTOReactivo> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDTOReactivo> productos) {
        this.productos = productos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
