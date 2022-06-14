package com.uptc.entrenamiento.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TIPO_EJERCICIOS")
public class TipoEjercicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoEjercicio;
    @Column(nullable = true, length = 50)
    private String dscTipoEjercicio;

    public TipoEjercicio() {
    }

    public TipoEjercicio(Long idTipoEjercicio) {
        this.idTipoEjercicio = idTipoEjercicio;
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

    @Override
    public String toString() {
        return "TipoEjercicio{" +
                "idTipoEjercicio=" + idTipoEjercicio +
                ", dscTipoEjercicio='" + dscTipoEjercicio + '\'' +
                '}';
    }
}
