package com.practice.tacos.repo.jpa;

import com.practice.tacos.domain.jpa.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
