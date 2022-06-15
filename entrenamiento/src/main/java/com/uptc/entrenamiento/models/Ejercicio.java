package com.uptc.entrenamiento.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "EJERCICIOS")
public class Ejercicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEjercicio;
    @Column(nullable = true, length = 50)
    private String nombreEjercicio;
    @Column(nullable = true, length = 200)
    private String dscEjercicio;

    @ManyToOne
    @JoinColumn(name = "idTipoEjercicio")
    TipoEjercicio tipoEjercicio;

    @ManyToMany(mappedBy = "ejercicios")
    private List<ParteCuerpo> parteCuerpoList;

    public Ejercicio() {
    }

    public Ejercicio(String nombreEjercicio, String dscEjercicio) {
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

    public TipoEjercicio getTipoEjercicio() {
        return tipoEjercicio;
    }

    public void setTipoEjercicio(TipoEjercicio tipoEjercicio) {
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
