package com.practice.tacos.service;

import com.google.common.collect.Lists;
import com.practice.tacos.domain.jpa.Ingredient;
import com.practice.tacos.repo.jpa.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DesignTacoService {

    /**
     * Default package and usage: JPA.
     * The repo can be used with JDBC Template, JDBC Data or JPA.
     * To switch, change the import packages.
     */
    private final IngredientRepository ingredientRepository;

    public List<Ingredient> getAllIngredients(){
        return Lists.newArrayList(ingredientRepository.findAll());
    }
}
