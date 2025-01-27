package com.practice.tacos.repo;

import com.practice.tacos.domain.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, String> {

}
