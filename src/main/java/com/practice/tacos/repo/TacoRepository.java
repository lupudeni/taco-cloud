package com.practice.tacos.repo;

import com.practice.tacos.domain.Taco;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TacoRepository extends CrudRepository<Taco, UUID> {
}
