package com.example.API_ferreteria.services;

import com.example.API_ferreteria.domain.InventarioDTOReactivo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IInventarioReactivoService {
    Mono<InventarioDTOReactivo> save (InventarioDTOReactivo inventarioDTOReactivo);
    Flux<InventarioDTOReactivo> findAll();
}
