package com.example.API_ferreteria.services;


import com.example.API_ferreteria.domain.ProveedorDTOReactivo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProveedorReactivoService {
    Mono<ProveedorDTOReactivo> save (ProveedorDTOReactivo proveedorDTOReactivo);
    Mono<ProveedorDTOReactivo> delete (String id);
    Mono<ProveedorDTOReactivo> findById (String id);
    Flux<ProveedorDTOReactivo> findAll();
}
