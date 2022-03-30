package com.example.API_ferreteria.services.Impl;

import com.example.API_ferreteria.domain.VolanteDTOReactivo;
import com.example.API_ferreteria.repository.IVolanteReactivoRepository;
import com.example.API_ferreteria.services.IVolanteReactivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Primary
public class VolanteReactivoServiceImpl implements IVolanteReactivoService {

    @Autowired
    private IVolanteReactivoRepository iVolanteReactivoRepository;
    @Override
    public Mono<VolanteDTOReactivo> save(VolanteDTOReactivo volanteDTOReactivo) {
        return this.iVolanteReactivoRepository.save(volanteDTOReactivo);
    }

    @Override
    public Mono<VolanteDTOReactivo> delete(String id) {
        return this.iVolanteReactivoRepository.findById(id)
                .flatMap(volante -> this.iVolanteReactivoRepository
                        .deleteById(volante.getId()).thenReturn(volante));
    }

    @Override
    public Mono<VolanteDTOReactivo> findById(String id) {
        return this.iVolanteReactivoRepository.findById(id);
    }

    @Override
    public Flux<VolanteDTOReactivo> findAll() {
        return this.iVolanteReactivoRepository.findAll();
    }
}
