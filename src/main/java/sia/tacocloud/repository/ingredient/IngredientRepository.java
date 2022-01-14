package sia.tacocloud.repository.ingredient;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.domain.Ingredient;

import java.util.List;
import java.util.Optional;
//* Repository<Ingredient, String> first param is the persisted entity, second is the key
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

    List<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
