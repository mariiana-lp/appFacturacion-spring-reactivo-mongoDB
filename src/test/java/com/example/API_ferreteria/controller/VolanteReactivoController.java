package com.example.API_ferreteria.controller;

import com.example.API_ferreteria.domain.ProductoDTOReactivo;
import com.example.API_ferreteria.domain.VolanteDTOReactivo;
import com.example.API_ferreteria.services.IVolanteReactivoService;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class VolanteReactivoController {
    @MockBean
    private IVolanteReactivoService service;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("GET ALL/volante")
    public void getAll() throws Exception{
        VolanteDTOReactivo volante = new VolanteDTOReactivo();

        ProductoDTOReactivo producto1 = new ProductoDTOReactivo();
        producto1.setPrecioUnidad(400);
        producto1.setNombreProducto("Baldosa");
        List<ProductoDTOReactivo> productos = new ArrayList<>();
        productos.add(producto1);

        volante.setNombreProveedor("Luis");
        volante.setProductos(productos);
        volante.setFecha(LocalDate.now());
        volante.setDocumentoIdentidadProveedor("2234");

        List<VolanteDTOReactivo> list = new ArrayList<>();
        list.add(volante);

        Flux<VolanteDTOReactivo> flux = Flux.fromIterable(list);

        Mockito.when(service.findAll()).thenReturn(flux);

        webTestClient.get().uri("/volante").exchange().expectStatus();
        
    }
}
