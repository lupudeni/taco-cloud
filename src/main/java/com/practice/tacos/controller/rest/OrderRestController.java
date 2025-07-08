package com.practice.tacos.controller.rest;

import com.practice.tacos.domain.TacoOrder;
import com.practice.tacos.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path="/api/orders", produces="application/json")
@RestController
@AllArgsConstructor
public class OrderRestController {

    private OrderService orderService;

    @PatchMapping(path="/{orderId}", consumes="application/json")
    public TacoOrder patchOrder(@PathVariable("orderId") Long orderId, @RequestBody TacoOrder patchOrder) {
        return orderService.patchOrder(orderId, patchOrder);
    }
}
