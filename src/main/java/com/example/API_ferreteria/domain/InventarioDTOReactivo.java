package com.example.API_ferreteria.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection ="inventario" )
public class InventarioDTOReactivo {
    @Id
    private String id = UUID.randomUUID().toString().substring(0,10);
    private int cantidadActual;
    private int minimo;
    private int maximo;
}
