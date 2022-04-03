package com.example.API_ferreteria.repository;

import com.example.API_ferreteria.domain.ClienteDTOReactivo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IClienteReactivoRepository extends ReactiveMongoRepository<ClienteDTOReactivo, String> {
}
