package com.uptc.entrenamiento.services;

import com.uptc.entrenamiento.models.Registro;
import com.uptc.entrenamiento.utils.PageResponse;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IRegistroService {
    Iterable<Registro> findByAll();

    PageResponse findByAllPage(int page, int size);

    Optional<Registro> findById(Long id);

    Registro save(Registro registro);

    Registro update(Registro registro);

    void delete(Long id);
}
