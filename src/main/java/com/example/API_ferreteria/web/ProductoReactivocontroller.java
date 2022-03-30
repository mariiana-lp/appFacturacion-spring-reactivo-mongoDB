package com.example.API_ferreteria.web;

import com.example.API_ferreteria.domain.ProductoDTOReactivo;
import com.example.API_ferreteria.services.IProductoReactivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/producto")
public class ProductoReactivocontroller {
    @Autowired
    private IProductoReactivoService iProductoReactivoService;

    @PostMapping("/")
    private Mono<ProductoDTOReactivo> save (ProductoDTOReactivo productoDTOReactivo){
        return this.iProductoReactivoService.save(productoDTOReactivo);
    }

    @PutMapping("/{id}")
    private Mono<ResponseEntity<ProductoDTOReactivo>> delete (@PathVariable("id") String id){
        return this.iProductoReactivoService.delete(id)
                .flatMap(productoDTOReactivo -> Mono.just(ResponseEntity.ok(productoDTOReactivo)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping("/")
    private Flux<ProductoDTOReactivo> findAll(){
        return this.iProductoReactivoService.findAll();
    }

    @GetMapping("/{id}")
    private Mono<ProductoDTOReactivo> findById(@PathVariable("id") String id){
        return this.iProductoReactivoService.findById(id);
    }
}
