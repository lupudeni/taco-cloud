package com.practice.tacos.controller;

import com.practice.tacos.domain.Ingredient;
import com.practice.tacos.domain.Ingredient.Type;
import com.practice.tacos.domain.Taco;
import com.practice.tacos.domain.TacoOrder;
import com.practice.tacos.service.DesignTacoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
@AllArgsConstructor
public class DesignTacoController {

    private final DesignTacoService designTacoService;

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = designTacoService.getAllIngredients();

        Type[] types = Ingredient.Type.values();

        for(Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder tacoOrder() {
        return new TacoOrder();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(@Valid Taco taco,  Errors errors, @ModelAttribute TacoOrder tacoOrder) {
        if(errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> log.error("Errors: " + error.getDefaultMessage()));
            return "design";
        }

        designTacoService.processTaco(taco, tacoOrder);
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(ingredient -> ingredient.getType().equals(type))
                .collect(Collectors.toList());
    }
}
