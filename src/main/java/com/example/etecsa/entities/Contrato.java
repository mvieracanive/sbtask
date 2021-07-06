package com.example.etecsa.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Contrato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numero;
    private String descr;
    private String beneficiario;
    private String banco;
    private String cuenta;

    @OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL)
    private List<Factura> facturas;

    public Contrato() {
    }

    public Contrato(String numero, String descr, String beneficiario, String banco, String cuenta) {
        this.numero = numero;
        this.descr = descr;
        this.beneficiario = beneficiario;
        this.banco = banco;
        this.cuenta = cuenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
}