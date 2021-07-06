package com.example.etecsa.services;

import java.util.List;

import com.example.etecsa.entities.Butaca;
import com.example.etecsa.entities.Teatro;

public interface IButacaService {
    public Butaca salvar(Butaca pelicula);

    public List<Butaca> listar(Teatro teatro);

    public void eliminarPorId(Long id);

    public Butaca buscarPorId(Long id);

    public Integer getNumberOfSoldButacasByTeatro(Long teatroid);

    public Integer getNumberOfButacasFumadoresByTeatro(Long teatroid);

    public Float getRecaudadoBySoldButacasByTeatro(Long teatroid);

    // public List<Butaca> findByDuracionLessThan(int duracion);
}