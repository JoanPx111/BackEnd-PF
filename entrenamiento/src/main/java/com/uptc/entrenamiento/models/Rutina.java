package com.uptc.entrenamiento.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "RUTINAS")
public class Rutina implements Serializable {
    @Id
    @Column(nullable = false, length = 6)
    private Date dia;
    @Id
    @ManyToOne
    @JoinColumn(name = "idEspecialista")
    Especialista especialista;
    @Id
    @ManyToOne
    @JoinColumn(name = "idEjercicio")
    Ejercicio ejercicio;

    @Column(nullable = false)
    private Integer repeticion;

    @Column(nullable = false, length = 50)
    private String duracion;

    public Rutina() {
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public Integer getRepeticion() {
        return repeticion;
    }

    public void setRepeticion(Integer repeticion) {
        this.repeticion = repeticion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}
