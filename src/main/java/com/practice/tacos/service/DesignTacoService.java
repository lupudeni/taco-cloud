package com.practice.tacos.service;

import com.google.common.collect.Lists;
import com.practice.tacos.domain.Ingredient;
import com.practice.tacos.repo.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DesignTacoService {

    private final IngredientRepository ingredientRepository;

    public List<Ingredient> getAllIngredients(){
        return Lists.newArrayList(ingredientRepository.findAll());
    }
}
