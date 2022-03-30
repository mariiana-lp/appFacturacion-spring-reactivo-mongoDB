package com.example.API_ferreteria.repository;

import com.example.API_ferreteria.domain.InventarioDTOReactivo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IInventarioReactivoRepository extends ReactiveMongoRepository<InventarioDTOReactivo, String> {
}
