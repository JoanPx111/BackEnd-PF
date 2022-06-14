package com.uptc.entrenamiento.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GRUPO_DEPORTIVOS")
public class GrupoDeportivo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cscIntento;
    @ManyToOne
    @JoinColumn(name = "FK_ESPECIALISTA_GRUPODEPORTIVO", nullable = false)
    private Especialista especialista;

    @ManyToOne
    @JoinColumn(name = "FK_ESPECIALISTA_GRUPODEPORTIVO_02", nullable = false)
    private Especialista espIdEspecialista;
    @Column(nullable = false)
    private Integer intento;

    public GrupoDeportivo() {
    }

    public Long getCscIntento() {
        return cscIntento;
    }

    public void setCscIntento(Long cscIntento) {
        this.cscIntento = cscIntento;
    }

    public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    public Especialista getEspIdEspecialista() {
        return espIdEspecialista;
    }

    public void setEspIdEspecialista(Especialista espIdEspecialista) {
        this.espIdEspecialista = espIdEspecialista;
    }

    public Integer getIntento() {
        return intento;
    }

    public void setIntento(Integer intento) {
        this.intento = intento;
    }

    @Override
    public String toString() {
        return "GrupoDeportivo{" +
                "cscIntento=" + cscIntento +
                ", intento=" + intento +
                '}';
    }
}
