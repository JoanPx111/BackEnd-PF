package com.uptc.entrenamiento.repositories;

import com.uptc.entrenamiento.models.Ejercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjercicioRepository extends JpaRepository<Ejercicio, Long> {

}
