package com.practice.tacos.service;

import com.practice.tacos.domain.TacoOrder;
import com.practice.tacos.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public TacoOrder saveOrder(TacoOrder tacoOrder) {
        tacoOrder.setPlacedAt(new Date());
        return orderRepository.save(tacoOrder);
    }
}
