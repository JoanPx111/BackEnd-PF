package com.uptc.entrenamiento.controllers.utils.dto;

public class TipoEjercicioDto {

    private Long idTipoEjercicio;
    private String dscTipoEjercicio;

    public TipoEjercicioDto() {
    }

    public Long getIdTipoEjercicio() {
        return idTipoEjercicio;
    }

    public void setIdTipoEjercicio(Long idTipoEjercicio) {
        this.idTipoEjercicio = idTipoEjercicio;
    }

    public String getDscTipoEjercicio() {
        return dscTipoEjercicio;
    }

    public void setDscTipoEjercicio(String dscTipoEjercicio) {
        this.dscTipoEjercicio = dscTipoEjercicio;
    }
}
