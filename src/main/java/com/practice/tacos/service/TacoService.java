package com.practice.tacos.service;

import com.practice.tacos.domain.Taco;
import com.practice.tacos.repo.TacoRepository;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TacoService {

    private TacoRepository tacoRepository;

    public Iterable<Taco> findAllTacos() {
        PageRequest pageRequest = PageRequest.of(0, 12, Sort.by("createdAt").descending());
        return tacoRepository.findAll(pageRequest).getContent();
    }

    public Optional<Taco> getTacoById(@NotNull Long id) {
        return tacoRepository.findById(id);
    }

    public Taco postTaco(@NotNull Taco taco) {
       return tacoRepository.save(taco);
    }
}
