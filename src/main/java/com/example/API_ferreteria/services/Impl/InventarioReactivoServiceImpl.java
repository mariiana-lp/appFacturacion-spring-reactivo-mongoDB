package com.example.API_ferreteria.services.Impl;

import com.example.API_ferreteria.domain.InventarioDTOReactivo;
import com.example.API_ferreteria.domain.ProductoDTOReactivo;
import com.example.API_ferreteria.repository.IInventarioReactivoRepository;
import com.example.API_ferreteria.services.IInventarioReactivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Primary
public class InventarioReactivoServiceImpl implements IInventarioReactivoService {

    @Autowired
    private IInventarioReactivoRepository iInventarioReactivoRepository;

    @Override
    public Mono<InventarioDTOReactivo> save (InventarioDTOReactivo inventarioDTOReactivo) {
        return this.iInventarioReactivoRepository.save(inventarioDTOReactivo);
    }

    @Override
    public Flux<InventarioDTOReactivo> findAll() {
        return this.iInventarioReactivoRepository.findAll();
    }
}
