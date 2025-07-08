package com.practice.tacos.controller;

import com.practice.tacos.domain.Taco;
import com.practice.tacos.service.TacoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/tacos", produces="application/json")
@CrossOrigin(origins="http://tacocloud:8080") //TODO move to a security filter chain
@AllArgsConstructor
public class TacoController {

    private TacoService tacoService;

    @GetMapping(params="recent")
    public Iterable<Taco> getRecentTacos() {
        return tacoService.findAllTacos();
    }
}
