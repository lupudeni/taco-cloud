package com.practice.tacos.repo.jdbc.template;

import com.practice.tacos.domain.TacoOrder;

public interface OrderRepository {

    TacoOrder save(TacoOrder tacoOrder);
}
