package com.practice.tacos.repo.jdbc.template;

import com.practice.tacos.domain.jdbc.TacoOrder;

public interface OrderRepository {

    TacoOrder save(TacoOrder tacoOrder);
}
