package com.example.API_ferreteria.web;

import com.example.API_ferreteria.domain.VolanteDTOReactivo;
import com.example.API_ferreteria.services.IVolanteReactivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v")
public class VolanteReactivoResource {
    @Autowired
    private IVolanteReactivoService iVolanteReactivoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<VolanteDTOReactivo> save (@RequestBody  VolanteDTOReactivo volanteDTOReactivo){
        return this.iVolanteReactivoService.save(volanteDTOReactivo);
    }

    @PutMapping("/delete/{id}")
    private Mono<ResponseEntity<VolanteDTOReactivo>> delete (@PathVariable("id") String id){
        return this.iVolanteReactivoService.delete(id)
                .flatMap(volanteDTOReactivo -> Mono.just(ResponseEntity.ok(volanteDTOReactivo)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping
    private Flux<VolanteDTOReactivo> findAll(){
        return this.iVolanteReactivoService.findAll();
    }

    @GetMapping("/{id}")
    private Mono<VolanteDTOReactivo> findById(@PathVariable("id") String id){
        return this.iVolanteReactivoService.findById(id);
    }
}
