package com.practice.tacos.service;

import com.practice.tacos.domain.TacoOrder;
import com.practice.tacos.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void processOrder(TacoOrder tacoOrder, SessionStatus sessionStatus) {
        tacoOrder.setPlacedAt(new Date());
        TacoOrder submittedOrder = saveOrder(tacoOrder);
        log.info("Order submitted: {}", submittedOrder);
        sessionStatus.setComplete();
    }

    public TacoOrder saveOrder(TacoOrder tacoOrder) {
        return orderRepository.save(tacoOrder);
    }

    @PreAuthorize("hasRole('ADMIN')") //SpEL expression
    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }

    public TacoOrder patchOrder(Long orderId, TacoOrder patchOrder) {
        TacoOrder originalOrder =orderRepository.findById(orderId).orElseThrow();

        if (patchOrder.getDeliveryName() != null) {
            originalOrder.setDeliveryName(patchOrder.getDeliveryName());
        }
        if (patchOrder.getDeliveryStreet() != null) {
            originalOrder.setDeliveryStreet(patchOrder.getDeliveryStreet());
        }
        if (patchOrder.getDeliveryCity() != null) {
            originalOrder.setDeliveryCity(patchOrder.getDeliveryCity());
        }
        if (patchOrder.getDeliveryState() != null) {
            originalOrder.setDeliveryState(patchOrder.getDeliveryState());
        }
        if (patchOrder.getDeliveryZip() != null) {
            originalOrder.setDeliveryZip(patchOrder.getDeliveryZip());
        }
        if (patchOrder.getCcNumber() != null) {
            originalOrder.setCcNumber(patchOrder.getCcNumber());
        }
        if (patchOrder.getCcExpiration() != null) {
            originalOrder.setCcExpiration(patchOrder.getCcExpiration());
        }
        if (patchOrder.getCcCVV() != null) {
            originalOrder.setCcCVV(patchOrder.getCcCVV());
        }
        return orderRepository.save(originalOrder);

    }

    public void deleteOrderById(Long orderId) {
            orderRepository.deleteById(orderId);
    }
}
