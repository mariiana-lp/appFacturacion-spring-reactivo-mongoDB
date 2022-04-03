package com.example.API_ferreteria.repository;

import com.example.API_ferreteria.domain.ProveedorDTOReactivo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IProveedorReactivoRepository extends ReactiveMongoRepository<ProveedorDTOReactivo, String> {
}
