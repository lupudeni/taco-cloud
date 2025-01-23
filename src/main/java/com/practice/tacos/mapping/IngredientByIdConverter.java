package com.practice.tacos.mapping;

import com.practice.tacos.domain.Ingredient;
import com.practice.tacos.repo.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    // Used with JDBC Template package
//    private final IngredientRepository ingredientRepository;

    private final IngredientRepository ingredientRepository;

    @Override
    public Ingredient convert(String id) {
        return ingredientRepository.findById(id).orElse(null);
    }
}
