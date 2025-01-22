package com.practice.tacos.repo.jdbc.data;

import com.practice.tacos.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
