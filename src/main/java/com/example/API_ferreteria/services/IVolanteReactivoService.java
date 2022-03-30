package com.example.API_ferreteria.services;

import com.example.API_ferreteria.domain.FacturaDTOReactiva;
import com.example.API_ferreteria.domain.VolanteDTOReactivo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IVolanteReactivoService {
    Mono<VolanteDTOReactivo> save (VolanteDTOReactivo volanteDTOReactivo);
    Mono<VolanteDTOReactivo> delete (String id);
    Mono<VolanteDTOReactivo> findById (String id);
    Flux<VolanteDTOReactivo> findAll();
}
