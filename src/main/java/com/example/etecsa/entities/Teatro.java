package com.example.etecsa.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Teatro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;

    @Transient
    private Integer sold;

    @Transient
    private Integer fumadores;

    @Transient
    private Float recaudado;

    @OneToMany(mappedBy = "teatro", cascade = CascadeType.ALL)
    private List<Butaca> butacas;

    public List<Butaca> getButacas() {
        return butacas;
    }

    public void setButacas(List<Butaca> butacas) {
        this.butacas = butacas;
    }

    public Teatro() {
    }

    public Teatro(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public Integer getFumadores() {
        return fumadores;
    }

    public void setFumadores(Integer fumadores) {
        this.fumadores = fumadores;
    }

    public Float getRecaudado() {
        return recaudado;
    }

    public void setRecaudado(Float recaudado) {
        this.recaudado = recaudado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
