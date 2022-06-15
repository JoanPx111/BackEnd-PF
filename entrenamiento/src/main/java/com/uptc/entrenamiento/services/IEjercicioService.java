package com.uptc.entrenamiento.services;

import com.uptc.entrenamiento.models.Ejercicio;
import com.uptc.entrenamiento.utils.PageResponse;
import java.util.Optional;

public interface IEjercicioService {
    Iterable<Ejercicio> findByAll();

    PageResponse findByAllPage(int page, int size);

    Optional<Ejercicio> findById(Long id);

    Ejercicio save(Ejercicio creditModal);

    Ejercicio update(Ejercicio creditModal);

    Ejercicio delete(Long id);
}
