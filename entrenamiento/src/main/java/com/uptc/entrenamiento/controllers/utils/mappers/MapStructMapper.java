package com.uptc.entrenamiento.controllers.utils.mappers;

import com.uptc.entrenamiento.controllers.utils.dto.EjercicioDto;
import com.uptc.entrenamiento.controllers.utils.dto.TipoEjercicioDto;
import com.uptc.entrenamiento.models.Ejercicio;
import com.uptc.entrenamiento.models.TipoEjercicio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    TipoEjercicio tipoEjercicio(TipoEjercicioDto tipoEjercicioDto);

    TipoEjercicioDto tipoEjercicioDto(TipoEjercicio tipoEjercicio);

    Iterable<TipoEjercicioDto> tipoEjercicioDtos(Iterable<TipoEjercicio> tipoEjercicios);

    Ejercicio ejercicio(EjercicioDto ejercicioDto);

    EjercicioDto ejercicioDto(Ejercicio ejercicio);

    Iterable<EjercicioDto> ejercicioDtos(Iterable<Ejercicio> ejercicios);

}