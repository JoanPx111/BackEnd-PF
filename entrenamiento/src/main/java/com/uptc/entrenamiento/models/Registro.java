package com.uptc.entrenamiento.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "REGISTROS")
public class Registro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistro;
    @Column(nullable = true, length = 6)
    private Date fechaRegistro;

    @OneToOne
    @JoinColumn(name = "FK_ESPECIALISTA_REGISTRO")
    Especialista especialista;

    public Registro() {
    }

    @Override
    public String toString() {
        return "Registro{" +
                "idRegistro=" + idRegistro +
                ", fechaRegistro=" + fechaRegistro +
                '}';
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

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }
}
