package com.practice.tacos.controller.rest;

import com.practice.tacos.domain.Taco;
import com.practice.tacos.service.TacoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/api/tacos", produces="application/json")
@CrossOrigin(origins="http://tacocloud:8080") //TODO move to a security filter chain
@AllArgsConstructor
public class TacoRestController {

    private TacoService tacoService;

    @GetMapping(params="recent")
    public Iterable<Taco> getRecentTacos() {
        return tacoService.findAllTacos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> getTacoById(@PathVariable("id") Long id) {
        Optional<Taco> taco = tacoService.getTacoById(id);
        return taco.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoService.postTaco(taco);
    }

}
