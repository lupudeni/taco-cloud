package com.practice.tacos.repo.jdbc.template;

import com.practice.tacos.domain.jdbc.Taco;

import java.util.List;

public interface TacoRepository {

    void save(Long orderId, Taco taco);

    void saveTacos(Long orderId, List<Taco> tacos);
}
