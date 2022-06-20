package com.uptc.entrenamiento.controllers.utils.dto;

import java.util.Date;

public class EspecialistaDto {
    private Long idEspecialista;
    private String nombre;
    private Date fechaDeNacimiento;
    private String tarjetaProfesional;
    private RegistroDto registro;

    public EspecialistaDto() {
    }

    public Long getIdEspecialista() {
        return idEspecialista;
    }

    public void setIdEspecialista(Long idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getTarjetaProfesional() {
        return tarjetaProfesional;
    }

    public void setTarjetaProfesional(String tarjetaProfesional) {
        this.tarjetaProfesional = tarjetaProfesional;
    }

    public RegistroDto getRegistro() {
        return registro;
    }

    public void setRegistro(RegistroDto registro) {
        this.registro = registro;
    }
}
