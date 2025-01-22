package com.practice.tacos.repo.jdbc.template.impl;

import com.practice.tacos.domain.Taco;
import com.practice.tacos.repo.jdbc.template.IngredientRepository;
import com.practice.tacos.repo.jdbc.template.TacoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.asm.Type;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcTacoRepository implements TacoRepository {

    private final JdbcOperations jdbcOperations;

    private final IngredientRepository ingredientRepository;

    @Override
    public void save(Long orderId, Taco taco) {
        taco.setCreatedAt(new Date());

        PreparedStatementCreatorFactory pscf =
                new PreparedStatementCreatorFactory(
                        "insert into Taco "
                                + "(name, created_at, taco_order) "
                                + "values (?, ?, ?)",
                        Types.VARCHAR, Types.TIMESTAMP, Type.LONG
                );
        pscf.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc =
                pscf.newPreparedStatementCreator(
                        Arrays.asList(
                                taco.getName(),
                                taco.getCreatedAt(),
                                orderId));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long tacoId = keyHolder.getKey().longValue();
        taco.setId(tacoId);

        ingredientRepository.saveIngredientRef(tacoId, taco.getIngredients());

    }

    @Override
    public void saveTacos(Long orderId, List<Taco> tacos) {
        for(Taco taco : tacos) {
            save(orderId, taco);
        }
    }


}
