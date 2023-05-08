package sia.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.tacocloud.domain.Ingredient;
//* Repository<Ingredient, String> first param is the persisted entity, second is the key
@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
