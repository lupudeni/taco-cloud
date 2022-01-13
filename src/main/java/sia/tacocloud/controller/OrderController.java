package sia.tacocloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sia.tacocloud.domain.TacoOrder;
import sia.tacocloud.util.Path;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    private static final String ORDER_FORM = "orderForm";

    @GetMapping("/current")
    public String getOrderForm(Model model) {
        model.addAttribute("tacoOrder", new TacoOrder());
        return ORDER_FORM;
    }

    @PostMapping
    public String processOrder(@Valid @ModelAttribute("tacoOrder") TacoOrder tacoOrder, Errors errors) {
        if (errors.hasErrors()) {
            return ORDER_FORM;
        }
        log.info("Order submitted: " + tacoOrder);
        return Path.REDIRECT;
    }
}
