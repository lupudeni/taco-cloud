package sia.tacocloud.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import sia.tacocloud.domain.TacoOrder;
import sia.tacocloud.domain.User;
import sia.tacocloud.repository.OrderRepository;
import sia.tacocloud.service.OrderAdminService;
import sia.tacocloud.util.Path;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
@AllArgsConstructor
public class OrderController {

    private static final String ORDER_FORM = "orderForm";

    private  OrderRepository orderRepository;

    @Autowired
    private OrderAdminService orderService;

    @GetMapping("/current")
    public String getOrderForm(Model model) {
        model.addAttribute("tacoOrder", new TacoOrder());
        return ORDER_FORM;
    }

    @PostMapping
    public String processOrder(@Valid @ModelAttribute("tacoOrder") TacoOrder tacoOrder, Errors errors, SessionStatus sessionStatus, @AuthenticationPrincipal User authenthicatedUser) {
        if (errors.hasErrors()) {
            return ORDER_FORM;
        }

        tacoOrder.setUser(authenthicatedUser);

        orderRepository.save(tacoOrder);
        sessionStatus.setComplete();
        return Path.REDIRECT;
    }


}
