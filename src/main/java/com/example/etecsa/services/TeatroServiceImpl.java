package com.example.etecsa.services;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.etecsa.entities.Contrato;
import com.example.etecsa.entities.Teatro;
import com.example.etecsa.repositories.ITeatroRepo;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TeatroServiceImpl implements ITeatroService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ITeatroRepo repo;

    @Autowired
    private IButacaService serviceb;

    @Override
    public Teatro salvar(Teatro obj) {
        // entityManager.persist(obj);
        return repo.save(obj);
    }

    @Override
    public List<Teatro> listar() {
        List<Teatro> ts = repo.findAll();
        for (int i = 0; i < ts.size(); i++) {
            Teatro t = ts.get(i);
            Integer sold = serviceb.getNumberOfSoldButacasByTeatro(t.getId());
            Integer fumadores = serviceb.getNumberOfButacasFumadoresByTeatro(t.getId());
            Float recaudado = serviceb.getRecaudadoBySoldButacasByTeatro(t.getId());
            t.setSold(sold);
            t.setRecaudado(recaudado);
            t.setFumadores(fumadores);
        }
        return ts;
    }

    @Override
    public void eliminarPorId(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Teatro buscarPorId(Long id) {
        return repo.findById(id).get();
    }

}