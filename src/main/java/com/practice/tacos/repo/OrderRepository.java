package com.practice.tacos.repo;

import com.practice.tacos.domain.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface OrderRepository extends CrudRepository<TacoOrder, UUID> {

    List<TacoOrder> findByDeliveryZip(String deliveryZip);

    List<TacoOrder> findByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);
}
