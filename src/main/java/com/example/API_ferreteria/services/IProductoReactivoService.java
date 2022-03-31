package com.example.API_ferreteria.services;

import com.example.API_ferreteria.domain.FacturaDTOReactiva;
import com.example.API_ferreteria.domain.ProductoDTOReactivo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductoReactivoService {
    Mono<ProductoDTOReactivo> save (ProductoDTOReactivo productoDTOReactivo);
    Mono<ProductoDTOReactivo> delete (String id);
    Mono<ProductoDTOReactivo> findById (String id);
    Flux<ProductoDTOReactivo> findAll();
    Mono<ProductoDTOReactivo> update(String id, ProductoDTOReactivo productoDTOReactivo);
}
