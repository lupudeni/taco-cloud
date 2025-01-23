package com.practice.tacos.repo.jdbc.template;

import com.practice.tacos.domain.jdbc.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);

    void saveIngredientRef(long tacoId, List<Ingredient> ingredients);

}
