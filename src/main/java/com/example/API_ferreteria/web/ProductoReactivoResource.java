package com.example.API_ferreteria.web;

import com.example.API_ferreteria.domain.ProductoDTOReactivo;
import com.example.API_ferreteria.services.IProductoReactivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:3001", maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductoReactivoResource {
    @Autowired
    private IProductoReactivoService iProductoReactivoService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<ProductoDTOReactivo> save (@RequestBody  ProductoDTOReactivo productoDTOReactivo){
        return this.iProductoReactivoService.save(productoDTOReactivo);
    }

    @PutMapping("/update/{id}")
    private Mono<ResponseEntity<ProductoDTOReactivo>> update (@PathVariable("id") String id, @RequestBody ProductoDTOReactivo productoDTOReactivo){
        return this.iProductoReactivoService.update(id, productoDTOReactivo)
                .flatMap(productoDTOReactivo1 -> Mono.just(ResponseEntity.ok(productoDTOReactivo)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/{id}")
    private Mono<ResponseEntity<ProductoDTOReactivo>> delete (@PathVariable("id") String id){
        return this.iProductoReactivoService.delete(id)
                .flatMap(productoDTOReactivo -> Mono.just(ResponseEntity.ok(productoDTOReactivo)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping
    private Flux<ProductoDTOReactivo> findAll(){
        return this.iProductoReactivoService.findAll();
    }

    @GetMapping("/{id}")
    private Mono<ProductoDTOReactivo> findById(@PathVariable("id") String id){
        return this.iProductoReactivoService.findById(id);
    }
}
