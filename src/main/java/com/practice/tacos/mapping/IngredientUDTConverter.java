package com.practice.tacos.mapping;

import com.practice.tacos.domain.Ingredient;
import com.practice.tacos.domain.IngredientUDT;
import com.practice.tacos.repo.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IngredientUDTConverter implements Converter<String, IngredientUDT> {

    private final IngredientRepository ingredientRepository;

    @Override
    public IngredientUDT convert(String id) {
        Ingredient ingredient = ingredientRepository.findById(id).orElse(null);

        return ingredient != null ? new IngredientUDT(ingredient.getName(), ingredient.getType()) : null;
    }
}
