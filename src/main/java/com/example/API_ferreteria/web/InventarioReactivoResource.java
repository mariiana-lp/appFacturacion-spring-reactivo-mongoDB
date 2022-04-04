package com.example.API_ferreteria.web;

import com.example.API_ferreteria.domain.InventarioDTOReactivo;
import com.example.API_ferreteria.services.IInventarioReactivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/i")
public class InventarioReactivoResource {
    @Autowired
    private IInventarioReactivoService iInventarioReactivoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<InventarioDTOReactivo> save (@RequestBody InventarioDTOReactivo inventarioDTOReactivo){
        return this.iInventarioReactivoService.save(inventarioDTOReactivo);
    }

    @GetMapping
    private Flux<InventarioDTOReactivo> findAll(){
        return this.iInventarioReactivoService.findAll();
    }
}
