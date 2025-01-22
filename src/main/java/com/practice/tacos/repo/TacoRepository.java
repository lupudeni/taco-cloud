package com.practice.tacos.repo;

import com.practice.tacos.domain.Taco;

import java.util.List;

public interface TacoRepository {

    void save(Long orderId, Taco taco);

    void saveTacos(Long orderId, List<Taco> tacos);
}
