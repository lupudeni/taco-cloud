package sia.tacocloud.conevrter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sia.tacocloud.domain.Ingredient;
import sia.tacocloud.repository.ingredient.IngredientRepository;
import sia.tacocloud.repository.ingredient.JdbcIngredientRepository;

@Component
//* makes it discoverable as a bean in the Spring application context. Spring Boot autoconfiguration will discover it
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientByIdConverter(JdbcIngredientRepository jdbcIngredientRepository) {
        this.ingredientRepository = jdbcIngredientRepository;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientRepository.findById(id).orElse(null);
    }
}
