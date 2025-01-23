package com.practice.tacos.repo.jdbc.template.impl;

import com.practice.tacos.domain.jdbc.Ingredient;
import com.practice.tacos.repo.jdbc.template.IngredientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class JdbcIngredientRepository implements IngredientRepository {

    private final JdbcTemplate jdbcTemplate;

    private final JdbcOperations jdbcOperations;

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query("select id, name, type from Ingredient", this::mapResultSetToIngredients);
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        List<Ingredient> ingredients = jdbcTemplate.query("select id, name, type from Ingredient where id=?", this::mapResultSetToIngredients, id);
        if(ingredients != null) {
            return ingredients.stream().findFirst();
        }
        log.error("Ingredients list is null");
        return Optional.empty();
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update("insert into Ingredient (id, name, type) values (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient; //TODO this should be the resulted new ingredient in the db, not the one provided
    }

    public void saveIngredientRef(long tacoId, List<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            jdbcOperations.update(
                    "insert into Ingredient_Ref (ingredient, taco) "
                            + "values (?, ?)",
                    ingredient, tacoId);
        }
    }

    private List<Ingredient> mapResultSetToIngredients(ResultSet resultSet) throws SQLException {
        List<Ingredient> ingredients = new ArrayList<>();
        if (resultSet.first()) {
            do {
                ingredients.add(new Ingredient(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        Ingredient.Type.valueOf(resultSet.getString("type"))));
            } while (resultSet.next());
        }
        return ingredients;
    }
}
