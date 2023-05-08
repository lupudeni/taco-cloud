package sia.tacocloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import sia.tacocloud.domain.Ingredient;
import sia.tacocloud.domain.Taco;
import sia.tacocloud.repository.IngredientRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static sia.tacocloud.domain.Ingredient.Type;
//* this generates at compile time a Simple Logging Facade for Java. It's a logger. Comes from Lombok
@Slf4j
//* spring automatically creates an interface as a bean in the spring application context due to this annotation
@Controller
//* when applied at class level, specifies the path for the requests for this controller. General purpose request handling
@RequestMapping("/design")
@SessionAttributes("tacoOrder") //? what is this?
public class DesignTacoController {

    private static final String DESIGN = "design";

    @Autowired
    private  IngredientRepository ingredientRepository;

    @ModelAttribute
    public void addIngredientsToModel(Model model) {

        List<Ingredient> ingredients = (List<Ingredient>) ingredientRepository.findAll();

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }

    }

    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("taco", new Taco());
        return DESIGN;
    }

    @PostMapping
    public String processTaco(@Valid @ModelAttribute("taco") Taco taco, Errors errors) {
        if (errors.hasErrors()) {
            return DESIGN;
        }

        log.info("Processing taco: " + taco.getName());
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(ingredient -> ingredient.getType().equals(type))
                .collect(Collectors.toList());
    }
}
