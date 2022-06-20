package com.uptc.entrenamiento.services;

import com.uptc.entrenamiento.models.Especialista;
import com.uptc.entrenamiento.utils.PageResponse;

import java.util.Optional;

public interface IEspecialistaService {
    Iterable<Especialista> findByAll();

    Optional<Especialista> findById(Long id);

    Especialista save(Especialista especialista);

    Especialista update(Especialista especialista);

    PageResponse findByAllPage(int page, int size);

    void delete(Long id);
}
