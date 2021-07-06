package com.example.etecsa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "fila_no_unique", columnNames = { "fila", "no" }) })
public class Butaca implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fila;
    private String no;
    private Boolean vendida;
    private Boolean platea;
    private Integer balcon;
    private Boolean protocolo;
    private Boolean fumador;

    @Transient
    private Float precio;

    @ManyToOne(fetch = FetchType.EAGER)
    private Teatro teatro;

    public Long getId() {
        return id;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBalcon() {
        if (balcon == null)
            return 0;
        return balcon;
    }

    public void setBalcon(Integer balcon) {
        this.balcon = balcon;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Boolean getPlatea() {
        if (platea == null)
            return false;
        return platea;
    }

    public void setPlatea(Boolean platea) {
        this.platea = platea;
    }

    public Boolean getProtocolo() {
        if (protocolo == null)
            return false;
        return protocolo;
    }

    public void setProtocolo(Boolean protocolo) {
        this.protocolo = protocolo;
    }

    public Boolean getFumador() {
        if (fumador == null)
            return false;
        return fumador;
    }

    public void setFumador(Boolean fumador) {
        this.fumador = fumador;
    }

    public Boolean getVendida() {
        if (vendida == null)
            return false;
        return vendida;
    }

    public void setVendida(Boolean vendida) {
        this.vendida = vendida;
    }

    public Float getPrecio() {
        if (this.getPlatea() && this.getProtocolo())
            return new Float(30);
        if (this.getPlatea() && !this.getProtocolo())
            return new Float(20);

        if (this.getFumador())
            return new Float(this.getBalcon() * 0.5 + 5);

        return new Float(this.getBalcon() * 0.5);
    }

    public Teatro getTeatro() {
        return teatro;
    }

    public void setTeatro(Teatro teatro) {
        this.teatro = teatro;
    }
}
