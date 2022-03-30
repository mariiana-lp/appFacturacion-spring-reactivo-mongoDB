package com.example.API_ferreteria.repository;

import com.example.API_ferreteria.domain.ProductoDTOReactivo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IProductoReactivoRepository extends ReactiveMongoRepository<ProductoDTOReactivo, String> {
}
