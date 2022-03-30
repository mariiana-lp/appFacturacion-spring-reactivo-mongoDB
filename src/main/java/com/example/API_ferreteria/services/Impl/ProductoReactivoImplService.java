package com.example.API_ferreteria.services.Impl;


import com.example.API_ferreteria.domain.ProductoDTOReactivo;
import com.example.API_ferreteria.repository.IProductoReactivoRepository;
import com.example.API_ferreteria.services.IProductoReactivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoReactivoImplService implements IProductoReactivoService {

    @Autowired
    private IProductoReactivoRepository iProductoReactivoRepository;


    @Override
    public Mono<ProductoDTOReactivo> save(ProductoDTOReactivo productoDTOReactivo) {
        return this.iProductoReactivoRepository.save(productoDTOReactivo);
    }

    @Override
    public Mono<ProductoDTOReactivo> delete(String id) {
        return this.iProductoReactivoRepository.findById(id)
                .flatMap(factura -> this.iProductoReactivoRepository
                        .deleteById(factura.getId()).thenReturn(factura));
    }

    @Override
    public Mono<ProductoDTOReactivo> findById(String id) {
        return this.iProductoReactivoRepository.findById(id);
    }

    @Override
    public Flux<ProductoDTOReactivo> findAll() {
        return this.iProductoReactivoRepository.findAll();
    }
}
