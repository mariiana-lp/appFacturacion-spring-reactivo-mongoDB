package com.example.API_ferreteria.controller;

import com.example.API_ferreteria.domain.ProductoDTOReactivo;
import com.example.API_ferreteria.services.IProductoReactivoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import reactor.core.publisher.Flux;


import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@CrossOrigin(origins = "http://localhost:3001")
public class ProductoReactivoControllerTest {
    @MockBean
    private IProductoReactivoService service;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("GET ALL/product")
    public void getAll() throws Exception{
        ProductoDTOReactivo producto = new ProductoDTOReactivo();
        producto.setNombreProducto("Lima");
        producto.setPrecioUnidad(2);

        List<ProductoDTOReactivo> list = new ArrayList<>();
        list.add(producto);

        Flux<ProductoDTOReactivo> flux = Flux.fromIterable(list);

        Mockito.when(service.findAll()).thenReturn(flux);

        webTestClient.get().uri("/product").exchange().expectStatus();
    }

}
