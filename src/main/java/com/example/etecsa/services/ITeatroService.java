package com.example.etecsa.services;

import java.util.List;

import com.example.etecsa.entities.Contrato;
import com.example.etecsa.entities.Teatro;

public interface ITeatroService {
    public Teatro salvar(Teatro obj);

    public List<Teatro> listar();

    public void eliminarPorId(Long id);

    public Teatro buscarPorId(Long id);

    // public List<Factura> findByDuracionLessThan(int duracion);
}