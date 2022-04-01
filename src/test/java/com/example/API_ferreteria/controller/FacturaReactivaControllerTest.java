package com.example.API_ferreteria.controller;


import com.example.API_ferreteria.domain.FacturaDTOReactiva;
import com.example.API_ferreteria.domain.ProductoDTOReactivo;
import com.example.API_ferreteria.services.IFacturaReactivaService;
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
public class FacturaReactivaControllerTest {
    @MockBean
    private IFacturaReactivaService service;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("GET ALL/factura")
    public void getAll() throws Exception{
        FacturaDTOReactiva factura = new FacturaDTOReactiva();
        List <ProductoDTOReactivo> productos = new ArrayList<>();
        ProductoDTOReactivo producto1 = new ProductoDTOReactivo();
        producto1.setNombreProducto("Tornillo");
        producto1.setPrecioUnidad(5);
        productos.add(producto1);

        factura.setNombreCliente("Harold");
        factura.setProductos(productos);


        List<FacturaDTOReactiva> list = new ArrayList<>();
        list.add(factura);

        Flux<FacturaDTOReactiva> flux = Flux.fromIterable(list);

        Mockito.when(service.findAll()).thenReturn(flux);

        webTestClient.get().uri("/factura").exchange().expectStatus();
    }
}
