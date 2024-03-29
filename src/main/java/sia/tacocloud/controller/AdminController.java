package sia.tacocloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sia.tacocloud.service.OrderAdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private OrderAdminService orderAdminService;

    @PostMapping("/deleteOrders")
    public String deleteAllOrders() {

        orderAdminService.deleteAll();
        return "redirect:/admin";

    }
}
