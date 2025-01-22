package com.practice.tacos.repo;

import com.practice.tacos.domain.TacoOrder;

public interface OrderRepository {

    TacoOrder save(TacoOrder tacoOrder);
}
