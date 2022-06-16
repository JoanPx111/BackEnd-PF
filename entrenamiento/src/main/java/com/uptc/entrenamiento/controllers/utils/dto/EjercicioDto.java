package com.uptc.entrenamiento.controllers.utils.dto;

import com.uptc.entrenamiento.models.ParteCuerpo;

import java.util.List;

public class EjercicioDto {
    private Long idEjercicio;
    private String nombreEjercicio;
    private String dscEjercicio;
    private TipoEjercicioDto tipoEjercicio;
    private List<ParteCuerpo> parteCuerpoList;

    public EjercicioDto() {
    }

    public EjercicioDto(String nombreEjercicio, String dscEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
        this.dscEjercicio = dscEjercicio;
    }

    public Long getIdEjercicio() {
        return idEjercicio;
    }

    public String getNombreEjercicio() {
        return nombreEjercicio;
    }

    public void setNombreEjercicio(String nombreEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
    }

    public String getDscEjercicio() {
        return dscEjercicio;
    }

    public void setDscEjercicio(String dscEjercicio) {
        this.dscEjercicio = dscEjercicio;
    }

    public TipoEjercicioDto getTipoEjercicio() {
        return tipoEjercicio;
    }

    public void setTipoEjercicio(TipoEjercicioDto tipoEjercicio) {
        this.tipoEjercicio = tipoEjercicio;
    }

    @Override
    public String toString() {
        return "Ejercicio{" +
                "idEjercicio=" + idEjercicio +
                ", nombreEjercicio='" + nombreEjercicio + '\'' +
                ", dscEjercicio='" + dscEjercicio + '\'' +
                ", tipoEjercicio=" + tipoEjercicio +
                ", parteCuerpoList=" + parteCuerpoList +
                '}';
    }
}
