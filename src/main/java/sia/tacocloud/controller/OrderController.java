package sia.tacocloud.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import sia.tacocloud.domain.TacoOrder;
import sia.tacocloud.repository.order.OrderRepository;
import sia.tacocloud.util.Path;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
@AllArgsConstructor
public class OrderController {

    private static final String ORDER_FORM = "orderForm";

    private final OrderRepository orderRepository;

    @GetMapping("/current")
    public String getOrderForm(Model model) {
        model.addAttribute("tacoOrder", new TacoOrder());
        return ORDER_FORM;
    }

    @PostMapping
    public String processOrder(@Valid @ModelAttribute("tacoOrder") TacoOrder tacoOrder, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return ORDER_FORM;
        }

        orderRepository.save(tacoOrder);
        sessionStatus.setComplete();
        return Path.REDIRECT;
    }
}
