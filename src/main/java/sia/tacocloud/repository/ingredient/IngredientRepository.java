package sia.tacocloud.repository.ingredient;

import sia.tacocloud.domain.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository {

    List<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
