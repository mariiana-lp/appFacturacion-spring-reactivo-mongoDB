package com.example.API_ferreteria.controller;

import com.example.API_ferreteria.domain.InventarioDTOReactivo;
import com.example.API_ferreteria.domain.ProductoDTOReactivo;
import com.example.API_ferreteria.services.IInventarioReactivoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class InventarioReactivoController {
    @MockBean
    private IInventarioReactivoService service;

    @Autowired
    protected WebTestClient webTestClient;

    @Test
    @DisplayName("GET ALL/inventario")
    public void getAll () throws Exception{
        InventarioDTOReactivo inventario = new InventarioDTOReactivo();
        ProductoDTOReactivo producto = new ProductoDTOReactivo();

        producto.setNombreProducto("Llave Inglesa");
        producto.setPrecioUnidad(220);

        inventario.setProductoDTOReactivo(producto);
        inventario.setCantidadActual(30);
        inventario.setMaximo(50);
        inventario.setMinimo(20);

        List<InventarioDTOReactivo> list = new ArrayList<>();
        list.add(inventario);

        Flux<InventarioDTOReactivo> flux = Flux.fromIterable(list);

        Mockito.when(service.findAll()).thenReturn(flux);

        webTestClient.get().uri("/inventario").exchange().expectStatus();
    }
}
