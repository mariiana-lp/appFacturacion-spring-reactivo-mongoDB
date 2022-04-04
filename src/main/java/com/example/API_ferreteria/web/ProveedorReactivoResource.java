package com.example.API_ferreteria.web;

import com.example.API_ferreteria.domain.ProductoDTOReactivo;
import com.example.API_ferreteria.domain.ProveedorDTOReactivo;
import com.example.API_ferreteria.services.IProductoReactivoService;
import com.example.API_ferreteria.services.IProveedorReactivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/proveedores")
public class ProveedorReactivoResource {
    @Autowired
    private IProveedorReactivoService iProveedorReactivoService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<ProveedorDTOReactivo> save (@RequestBody ProveedorDTOReactivo proveedorDTOReactivo){
        return this.iProveedorReactivoService.save(proveedorDTOReactivo);
    }

    @PutMapping("/{id}")
    private Mono<ResponseEntity<ProveedorDTOReactivo>> delete (@PathVariable("id") String id){
        return this.iProveedorReactivoService.delete(id)
                .flatMap(proveedorDTOReactivo -> Mono.just(ResponseEntity.ok(proveedorDTOReactivo)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping
    private Flux<ProveedorDTOReactivo> findAll(){
        return this.iProveedorReactivoService.findAll();
    }

    @GetMapping("/{id}")
    private Mono<ProveedorDTOReactivo> findById(@PathVariable("id") String id){
        return this.iProveedorReactivoService.findById(id);
    }
}
