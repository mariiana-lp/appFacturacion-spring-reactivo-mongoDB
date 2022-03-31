package com.example.API_ferreteria.web;

import com.example.API_ferreteria.domain.FacturaDTOReactiva;
import com.example.API_ferreteria.services.IFacturaReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/f")
public class FacturaReactivaResource {

    @Autowired
    private IFacturaReactivaService iFacturaReactivaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<FacturaDTOReactiva> save (@RequestBody FacturaDTOReactiva facturaDTOReactiva){
        return this.iFacturaReactivaService.save(facturaDTOReactiva);
    }

    @PutMapping("{id}")
    private Mono<ResponseEntity<FacturaDTOReactiva>> delete (@PathVariable("id") String id){
        return this.iFacturaReactivaService.delete(id)
                .flatMap(facturaDTOReactiva -> Mono.just(ResponseEntity.ok(facturaDTOReactiva)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping
    private Flux<FacturaDTOReactiva> findAll(){
        return this.iFacturaReactivaService.findAll();
    }

    @GetMapping("/{id}")
    private Mono<FacturaDTOReactiva> findById(@PathVariable("id") String id){
        return this.iFacturaReactivaService.findById(id);
    }
}
