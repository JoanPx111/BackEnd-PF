package com.uptc.entrenamiento.services;

import com.uptc.entrenamiento.models.TipoEjercicio;
import com.uptc.entrenamiento.utils.PageResponse;

import java.util.Optional;

public interface ITipoEjercicioService {
    Iterable<TipoEjercicio> findByAll();

    Optional<TipoEjercicio> findById(Long id);

    TipoEjercicio save(TipoEjercicio tipoEjercicio);

    TipoEjercicio update(TipoEjercicio ejercicio);

    PageResponse findByAllPage(int page, int size);

    void delete(Long id);
}
