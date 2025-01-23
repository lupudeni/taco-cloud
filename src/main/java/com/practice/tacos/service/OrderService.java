package com.practice.tacos.service;

import com.practice.tacos.domain.TacoOrder;
import com.practice.tacos.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    /**
     * Default package and usage: JPA.
     * The repo can be used with JDBC Template, JDBC Data or JPA.
     * To switch, use OrderRepository from either repo.jdbc.data or repo.jdbc.template
     */
    private final OrderRepository orderRepository;

    public TacoOrder saveOrder(TacoOrder tacoOrder) {
        return orderRepository.save(tacoOrder);
    }
}
