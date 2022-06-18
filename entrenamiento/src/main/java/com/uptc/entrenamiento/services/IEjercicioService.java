package com.uptc.entrenamiento.services;

import com.uptc.entrenamiento.models.Ejercicio;
import com.uptc.entrenamiento.utils.PageResponse;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IEjercicioService {
    Iterable<Ejercicio> findByAll();

    PageResponse findByAllPage(int page, int size);

    Optional<Ejercicio> findById(Long id);

    Ejercicio save(Ejercicio ejercicio);

    Ejercicio update(Ejercicio ejercicio);

    void delete(Long id);

    Iterable<Ejercicio> buscarPorNombre2(@Param("name") String nombreEjercicio);
}
