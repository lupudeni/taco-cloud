package com.practice.tacos.service;

import com.practice.tacos.domain.TacoOrder;
import com.practice.tacos.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    /**
     * Default package and usage: JPA.
     * The repo can be used with JDBC Template, JDBC Data or JPA.
     * To switch, use OrderRepository from either repo.jdbc.data or repo.jdbc.template
     */
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
}
