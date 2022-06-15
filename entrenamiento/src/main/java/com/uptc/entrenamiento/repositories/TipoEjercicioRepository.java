package com.uptc.entrenamiento.repositories;

import com.uptc.entrenamiento.models.TipoEjercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEjercicioRepository extends JpaRepository<TipoEjercicio, Long> {
}
