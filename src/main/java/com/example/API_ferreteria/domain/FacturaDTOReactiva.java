package com.example.API_ferreteria.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Document(collection = "facturas")
public class FacturaDTOReactiva {
    @Id
    private String id = UUID.randomUUID().toString().substring(0,10);
    private LocalDate fecha;
    private String nombreCliente;
    private String vendedor; //Quien atendio al cliente
    private List<ProductoDTOReactivo> productos;
    private int totalAPagar;

    public FacturaDTOReactiva(String id, LocalDate fecha, String nombreCliente, String vendedor, List<ProductoDTOReactivo> productos, int totalAPagar) {
        this.id = id;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.vendedor = vendedor;
        this.productos = productos;
        this.totalAPagar = totalAPagar;
    }

    public FacturaDTOReactiva(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public List<ProductoDTOReactivo> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDTOReactivo> productos) {
        this.productos = productos;
    }

    public int getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(int totalAPagar) {
        this.totalAPagar = totalAPagar;
    }
}
