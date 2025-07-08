package com.practice.tacos.controller.rest;

import com.practice.tacos.domain.TacoOrder;
import com.practice.tacos.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path="/api/orders", produces="application/json")
@RestController
@AllArgsConstructor
@Slf4j
public class OrderRestController {

    private OrderService orderService;

    @PatchMapping(path="/{orderId}", consumes="application/json")
    public TacoOrder patchOrder(@PathVariable("orderId") Long orderId, @RequestBody TacoOrder patchOrder) {
        return orderService.patchOrder(orderId, patchOrder);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<TacoOrder> deleteOrder(@PathVariable("orderId") Long orderId) {
        try {
            orderService.deleteOrderById(orderId);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
