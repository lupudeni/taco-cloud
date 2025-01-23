package com.practice.tacos.repo;

import com.practice.tacos.domain.TacoOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<TacoOrder, Long> {

    List<TacoOrder> findByDeliveryZip(String deliveryZip);

    List<TacoOrder> findByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);
}
