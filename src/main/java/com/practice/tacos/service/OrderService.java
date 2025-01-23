package com.practice.tacos.service;

import com.practice.tacos.domain.jpa.TacoOrder;
import com.practice.tacos.repo.jpa.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    /**
     * Default package and usage: JPA.
     * The repo can be used with JDBC Template, JDBC Data or JPA. The domain packages also need to be adjusted in that case.
     * To switch, change the import packages.
     */
    private final OrderRepository orderRepository;

    public TacoOrder saveOrder(TacoOrder tacoOrder) {
        return orderRepository.save(tacoOrder);
    }
}
