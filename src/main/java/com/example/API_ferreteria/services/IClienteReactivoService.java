package com.example.API_ferreteria.services;

import com.example.API_ferreteria.domain.ClienteDTOReactivo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClienteReactivoService {
    Mono<ClienteDTOReactivo> save (ClienteDTOReactivo clienteDTOReactivo);
    Mono<ClienteDTOReactivo> delete (String id);
    Mono<ClienteDTOReactivo> findById (String id);
    Flux<ClienteDTOReactivo> findAll();
}
