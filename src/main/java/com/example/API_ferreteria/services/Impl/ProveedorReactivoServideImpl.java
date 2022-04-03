package com.example.API_ferreteria.services.Impl;

import com.example.API_ferreteria.domain.ProveedorDTOReactivo;
import com.example.API_ferreteria.repository.IProveedorReactivoRepository;
import com.example.API_ferreteria.services.IProveedorReactivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Primary
public class ProveedorReactivoServideImpl implements IProveedorReactivoService {

    @Autowired
    private IProveedorReactivoRepository iProveedorReactivoRepository;

    @Override
    public Mono<ProveedorDTOReactivo> save(ProveedorDTOReactivo proveedorDTOReactivo) {
        return this.iProveedorReactivoRepository.save(proveedorDTOReactivo);
    }

    @Override
    public Mono<ProveedorDTOReactivo> delete(String id) {
        return this.iProveedorReactivoRepository.findById(id)
                .flatMap(proveedor -> this.iProveedorReactivoRepository.deleteById(id)
                        .thenReturn(proveedor));
    }

    @Override
    public Mono<ProveedorDTOReactivo> findById(String id) {
        return this.iProveedorReactivoRepository.findById(id);
    }

    @Override
    public Flux<ProveedorDTOReactivo> findAll() {
        return this.iProveedorReactivoRepository.findAll();
    }
}
