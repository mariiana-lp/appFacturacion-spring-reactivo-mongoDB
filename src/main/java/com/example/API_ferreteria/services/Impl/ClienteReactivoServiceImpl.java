package com.example.API_ferreteria.services.Impl;

import com.example.API_ferreteria.domain.ClienteDTOReactivo;
import com.example.API_ferreteria.repository.IClienteReactivoRepository;
import com.example.API_ferreteria.services.IClienteReactivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Primary
public class ClienteReactivoServiceImpl implements IClienteReactivoService {

    @Autowired
    private IClienteReactivoRepository iClienteReactivoRepository;

    @Override
    public Mono<ClienteDTOReactivo> save(ClienteDTOReactivo clienteDTOReactivo) {
        return this.iClienteReactivoRepository.save(clienteDTOReactivo);
    }

    @Override
    public Mono<ClienteDTOReactivo> delete(String id) {
        return this.iClienteReactivoRepository.findById(id)
                .flatMap(cliente -> this.iClienteReactivoRepository.deleteById(id)
                        .thenReturn(cliente));
    }

    @Override
    public Mono<ClienteDTOReactivo> findById(String id) {
        return this.iClienteReactivoRepository.findById(id);
    }

    @Override
    public Flux<ClienteDTOReactivo> findAll() {
        return this.iClienteReactivoRepository.findAll();
    }
}
