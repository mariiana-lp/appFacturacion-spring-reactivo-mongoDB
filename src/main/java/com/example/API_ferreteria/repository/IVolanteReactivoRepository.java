package com.example.API_ferreteria.repository;

import com.example.API_ferreteria.domain.VolanteDTOReactivo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IVolanteReactivoRepository extends ReactiveMongoRepository<VolanteDTOReactivo, String> {
}
