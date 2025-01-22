package com.practice.tacos.repo.impl;

import com.practice.tacos.domain.TacoOrder;
import com.practice.tacos.repo.OrderRepository;
import com.practice.tacos.repo.TacoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

@Slf4j
@Repository
@RequiredArgsConstructor
public class JdbcOrderRepository implements OrderRepository {

    private final JdbcOperations jdbcOperations;

    private final TacoRepository tacoRepository;

    @Override
    @Transactional
    public TacoOrder save(TacoOrder tacoOrder) {
        PreparedStatementCreatorFactory pscf =
                new PreparedStatementCreatorFactory("insert into Taco_Order "
                        + "(delivery_name, delivery_street, delivery_city, "
                        + "delivery_state, delivery_zip, cc_number, "
                        + "cc_expiration, cc_cvv, placed_at) "
                        + "values (?,?,?,?,?,?,?,?,?)",
                        Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                        Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                        Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP);

        pscf.setReturnGeneratedKeys(true);
        tacoOrder.setPlacedAt(new Date());

        PreparedStatementCreator psc =
                pscf.newPreparedStatementCreator(
                        Arrays.asList(
                                tacoOrder.getDeliveryName(),
                                tacoOrder.getDeliveryStreet(),
                                tacoOrder.getDeliveryCity(),
                                tacoOrder.getDeliveryState(),
                                tacoOrder.getDeliveryZip(),
                                tacoOrder.getCcNumber(),
                                tacoOrder.getCcExpiration(),
                                tacoOrder.getCcCVV(),
                                tacoOrder.getPlacedAt()));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcOperations.update(psc, keyHolder);
        long orderId= keyHolder.getKey().longValue();
        tacoOrder.setId(orderId);

        tacoRepository.saveTacos(orderId, tacoOrder.getTacos());
        return tacoOrder;
    }
}
