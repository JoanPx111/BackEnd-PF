package com.uptc.entrenamiento.controllers.utils.mappers;

import com.uptc.entrenamiento.controllers.utils.dto.EjercicioDto;
import com.uptc.entrenamiento.controllers.utils.dto.EspecialistaDto;
import com.uptc.entrenamiento.controllers.utils.dto.RegistroDto;
import com.uptc.entrenamiento.controllers.utils.dto.TipoEjercicioDto;
import com.uptc.entrenamiento.models.Ejercicio;
import com.uptc.entrenamiento.models.Especialista;
import com.uptc.entrenamiento.models.Registro;
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

    EspecialistaDto especialistaDto(Especialista especialista);

    Especialista especialista(EspecialistaDto especialistaDto);

    Iterable<EspecialistaDto> especialistaDtos(Iterable<Especialista> especialistas);

    Iterable<Especialista> especialistas(Iterable<EspecialistaDto> especialistaDtos);

    Registro registro(RegistroDto registroDto);

    RegistroDto registroDto(Registro registro);

    Iterable<RegistroDto> registroDtos(Iterable<Registro> registros);

    Iterable<Registro> registros(Iterable<RegistroDto> registroDtos);
}