package com.practice.tacos.mapping;

import com.practice.tacos.domain.Ingredient;
import com.practice.tacos.domain.IngredientUDT;
import com.practice.tacos.domain.Taco;
import com.practice.tacos.domain.TacoUDT;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UDTConverter {

    public static TacoUDT tacoToUdt(Taco taco) {
        return new TacoUDT(taco.getName(), taco.getIngredients());
    }

    public static IngredientUDT ingredientToUDT(Ingredient ingredient) {
        return new IngredientUDT(ingredient.getName(), ingredient.getType());
    }

    public static List<IngredientUDT> ingredientUDTsToList(List<Ingredient> ingredients) {
        return ingredients.stream().map(UDTConverter::ingredientToUDT).toList();
    }
}
