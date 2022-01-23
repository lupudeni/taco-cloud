package sia.tacocloud.repository.ingredient;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.domain.Ingredient;
//* Repository<Ingredient, String> first param is the persisted entity, second is the key
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
