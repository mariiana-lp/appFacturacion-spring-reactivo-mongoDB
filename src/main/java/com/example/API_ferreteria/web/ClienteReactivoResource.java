package com.example.API_ferreteria.web;

import com.example.API_ferreteria.domain.ClienteDTOReactivo;
import com.example.API_ferreteria.services.IClienteReactivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/clientes")
public class ClienteReactivoResource {
    @Autowired
    IClienteReactivoService iClienteReactivoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<ClienteDTOReactivo> save (@RequestBody  ClienteDTOReactivo clienteDTOReactivo){
        return this.iClienteReactivoService.save(clienteDTOReactivo);
    }

    @PutMapping("/{id}")
    private Mono<ResponseEntity<ClienteDTOReactivo>> delete (@PathVariable("id") String id){
        return this.iClienteReactivoService.delete(id)
                .flatMap(clienteDTOReactivo -> Mono.just(ResponseEntity.ok(clienteDTOReactivo)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping
    private Flux<ClienteDTOReactivo> findAll(){
        return this.iClienteReactivoService.findAll();
    }

    @GetMapping("/{id}")
    private Mono<ClienteDTOReactivo> findById(@PathVariable("id") String id){
        return this.iClienteReactivoService.findById(id);
    }
}
