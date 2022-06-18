package com.uptc.entrenamiento.repositories;

import com.uptc.entrenamiento.models.Ejercicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EjercicioRepository extends JpaRepository<Ejercicio, Long> {
    Iterable<Ejercicio> findByTipoEjercicioDscTipoEjercicioStartsWithIgnoreCase(String dscTipoEjercicio);

    Iterable<Ejercicio> findByNombreEjercicio(String nombreEjercicio);

    @Query(value = "SELECT * FROM EJERCICIOS E WHERE E.NOMBRE_EJERCICIO = :nombreEjercicio", nativeQuery = true)
    Iterable<Ejercicio> buscarPorNombre(@Param("nombreEjercicio") String nombreEjercicio);

    @Query(value = "SELECT E.ID_EJERCICIO,E.NOMBRE_EJERCICIO,E.DSC_EJERCICIO, E.ID_TIPO_EJERCICIO FROM EJERCICIOS E JOIN TIPO_EJERCICIOS T ON E.ID_TIPO_EJERCICIO = T.ID_TIPO_EJERCICIO WHERE E.NOMBRE_EJERCICIO = :name", nativeQuery = true)
    Iterable<Ejercicio> buscarPorNombre2(@Param("name") String nombreEjercicio);

    Optional<Ejercicio> findById(Long idEjercicio);

    Page<Ejercicio> findByNombreEjercicioStartsWithIgnoreCase(String nombreEjercicio, Pageable pageable);


}
