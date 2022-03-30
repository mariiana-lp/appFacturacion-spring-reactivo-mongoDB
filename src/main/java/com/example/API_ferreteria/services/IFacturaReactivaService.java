package com.example.API_ferreteria.services;

import com.example.API_ferreteria.domain.FacturaDTOReactiva;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IFacturaReactivaService {
    Mono<FacturaDTOReactiva> save (FacturaDTOReactiva facturaDTOReactiva);
    Mono<FacturaDTOReactiva> delete (String id);
    Mono<FacturaDTOReactiva> findById (String id);
    Flux<FacturaDTOReactiva> findAll();

}
