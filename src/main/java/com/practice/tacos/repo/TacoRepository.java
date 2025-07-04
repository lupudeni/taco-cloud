package com.practice.tacos.repo;

import com.practice.tacos.domain.Taco;
import com.practice.tacos.domain.TacoOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends JpaRepository<Taco, Long> {
}
