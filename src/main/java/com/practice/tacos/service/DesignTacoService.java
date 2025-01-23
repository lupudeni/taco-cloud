package com.practice.tacos.service;

import com.google.common.collect.Lists;
import com.practice.tacos.domain.jdbc.Ingredient;
import com.practice.tacos.repo.jdbc.data.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DesignTacoService {

    // Used with JDBC Template package
//    private final IngredientRepository ingredientRepository;

    private final IngredientRepository ingredientRepository;

    public List<Ingredient> getAllIngredients(){
        return Lists.newArrayList(ingredientRepository.findAll());
    }
}
