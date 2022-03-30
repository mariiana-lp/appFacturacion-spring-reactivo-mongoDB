package com.example.API_ferreteria.services.Impl;

import com.example.API_ferreteria.domain.FacturaDTOReactiva;
import com.example.API_ferreteria.repository.IFacturaReactivaRepository;
import com.example.API_ferreteria.services.IFacturaReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Primary
public class FacturaReactiveServiceImpl implements IFacturaReactivaService {

    @Autowired
    private IFacturaReactivaRepository iFacturaReactivaRepository;


    @Override
    public Mono<FacturaDTOReactiva> save(FacturaDTOReactiva facturaDTOReactiva) {
        return this.iFacturaReactivaRepository.save(facturaDTOReactiva);
    }

    @Override
    public Mono<FacturaDTOReactiva> delete(String id) {
        return this.iFacturaReactivaRepository.findById(id)
                .flatMap(factura -> this.iFacturaReactivaRepository
                        .deleteById(factura.getId()).thenReturn(factura));
    }

    @Override
    public Mono<FacturaDTOReactiva> findById(String id) {
        return this.iFacturaReactivaRepository.findById(id);
    }

    @Override
    public Flux<FacturaDTOReactiva> findAll() {
        return this.iFacturaReactivaRepository.findAll();
    }
}
