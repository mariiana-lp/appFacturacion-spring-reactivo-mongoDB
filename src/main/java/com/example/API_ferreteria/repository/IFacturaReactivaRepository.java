package com.example.API_ferreteria.repository;

import com.example.API_ferreteria.domain.FacturaDTOReactiva;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IFacturaReactivaRepository extends ReactiveMongoRepository<FacturaDTOReactiva, String> {
}
