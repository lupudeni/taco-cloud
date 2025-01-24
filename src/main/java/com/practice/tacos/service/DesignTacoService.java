package com.practice.tacos.service;

import com.google.common.collect.Lists;
import com.practice.tacos.domain.Ingredient;
import com.practice.tacos.domain.Taco;
import com.practice.tacos.domain.TacoOrder;
import com.practice.tacos.domain.TacoUDT;
import com.practice.tacos.repo.IngredientRepository;
import com.practice.tacos.repo.TacoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DesignTacoService {

    private final IngredientRepository ingredientRepository;

    private final TacoRepository tacoRepository;

    public List<Ingredient> getAllIngredients(){
        return Lists.newArrayList(ingredientRepository.findAll());
    }

    public void processTaco(Taco taco, TacoOrder tacoOrder) {
        taco.setCreatedAt(new Date());
        Taco savedTaco = tacoRepository.save(taco);

        tacoOrder.addTaco(new TacoUDT(savedTaco.getName(), savedTaco.getIngredients()));
        log.info("Processing taco: {}", savedTaco);
    }
}
