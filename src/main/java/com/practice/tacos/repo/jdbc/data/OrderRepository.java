package com.practice.tacos.repo.jdbc.data;

import com.practice.tacos.domain.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
}
