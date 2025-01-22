package com.practice.tacos.repo;

import com.practice.tacos.domain.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);

    void saveIngredientRef(long tacoId, List<Ingredient> ingredients);

}