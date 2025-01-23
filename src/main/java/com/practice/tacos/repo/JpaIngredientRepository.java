package com.practice.tacos.repo;

import com.practice.tacos.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaIngredientRepository extends JpaRepository<Ingredient, String> {
}
