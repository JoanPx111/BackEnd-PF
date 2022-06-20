package com.uptc.entrenamiento.controllers.utils.dto;

import java.util.Date;

public class RegistroDto {
    private Long idRegistro;
    private Date fechaRegistro;


    public RegistroDto() {
    }

    public Long getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Long idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
