package com.practice.tacos.service;

import com.practice.tacos.domain.jdbc.TacoOrder;
import com.practice.tacos.repo.jdbc.data.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    /**
     * Used with JDBC Template package
     */
    //private final OrderRepository orderRepository;

    /**
     * Used with JDBC Data
     */
    private final OrderRepository orderRepository;

    public TacoOrder saveOrder(TacoOrder tacoOrder) {
        return orderRepository.save(tacoOrder);
    }
}
