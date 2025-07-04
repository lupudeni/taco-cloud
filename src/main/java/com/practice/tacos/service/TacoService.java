package com.practice.tacos.service;

import com.practice.tacos.domain.Taco;
import com.practice.tacos.repo.TacoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TacoService {

    private TacoRepository tacoRepository;

    public Iterable<Taco> findAllTacos(PageRequest pageRequest) {
        return tacoRepository.findAll(pageRequest).getContent();
    }
}
