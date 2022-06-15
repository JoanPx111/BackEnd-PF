package com.uptc.entrenamiento.repositories;

import com.uptc.entrenamiento.models.GrupoDeportivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoDeportivoRepository extends JpaRepository<GrupoDeportivo, Long> {
}
