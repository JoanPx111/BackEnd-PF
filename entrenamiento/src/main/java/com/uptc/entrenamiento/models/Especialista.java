package com.uptc.entrenamiento.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ESPECIALISTAS")
public class Especialista implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEspecialista;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 6)
    private Date fechaDeNacimiento;
    @Column(nullable = false, length = 12)
    private String tarjetaProfesional;
    @OneToOne(mappedBy = "especialista", cascade = CascadeType.ALL)
    private Registro registro;

    public Especialista(String nombre, Date fechaDeNacimiento, String tarjetaProfesional, Registro registro) {
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.tarjetaProfesional = tarjetaProfesional;
        this.registro = registro;
    }

    public Especialista() {
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

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    @Override
    public String toString() {
        return "Especialista{" +
                "idEspecialista=" + idEspecialista +
                ", nombre='" + nombre + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", tarjetaProfesional='" + tarjetaProfesional + '\'' +
                ", registro=" + registro +
                '}';
    }
}
