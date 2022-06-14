package com.uptc.entrenamiento.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "PARTE_CUERPOS")
public class ParteCuerpo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMusculo;
    @Column(nullable = true, length = 50)
    private String dscMusculo;

    @JoinTable(
            name = "MUSCULO_EJERCICIOS",
            joinColumns = @JoinColumn(name = "idMusculo", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "idEjercicio", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Ejercicio> ejercicios;

    @ManyToOne
    @JoinColumn(name = "PAR_ID_MUSCULO")
    private ParteCuerpo parIdMusculo;

    public ParteCuerpo(String dscMusculo, List<Ejercicio> ejercicios, ParteCuerpo parIdMusculo) {
        this.dscMusculo = dscMusculo;
        this.ejercicios = ejercicios;
        this.parIdMusculo = parIdMusculo;
    }

    public ParteCuerpo() {
    }

    public ParteCuerpo getParIdMusculo() {
        return parIdMusculo;
    }

    public void setParIdMusculo(ParteCuerpo parIdMusculo) {
        this.parIdMusculo = parIdMusculo;
    }

    public Long getIdMusculo() {
        return idMusculo;
    }

    public void setIdMusculo(Long idMusculo) {
        this.idMusculo = idMusculo;
    }

    public String getDscMusculo() {
        return dscMusculo;
    }

    public void setDscMusculo(String dscMusculo) {
        this.dscMusculo = dscMusculo;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    @Override
    public String toString() {
        return "ParteCuerpo{" +
                "dscMusculo='" + dscMusculo + '\'' +
                '}';
    }
}
