package com.example.API_ferreteria.web;

import com.example.API_ferreteria.domain.FacturaDTOReactiva;
import com.example.API_ferreteria.services.IFacturaReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:3001", maxAge = 3600)
@RestController
public class FacturaReactivaResource {

    @Autowired
    private IFacturaReactivaService iFacturaReactivaService;

    @PostMapping("/f")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<FacturaDTOReactiva> save (@RequestBody FacturaDTOReactiva facturaDTOReactiva){
        return this.iFacturaReactivaService.save(facturaDTOReactiva);
    }

    @GetMapping("/f")
    private Flux<FacturaDTOReactiva> findAll(){
        return this.iFacturaReactivaService.findAll();
    }

    @PutMapping("/f/{id}")
    private Mono<ResponseEntity<FacturaDTOReactiva>> delete (@PathVariable("id") String id){
        return this.iFacturaReactivaService.delete(id)
                .flatMap(facturaDTOReactiva -> Mono.just(ResponseEntity.ok(facturaDTOReactiva)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping("/f/{id}")
    private Mono<FacturaDTOReactiva> findById(@PathVariable("id") String id){
        return this.iFacturaReactivaService.findById(id);
    }
}
