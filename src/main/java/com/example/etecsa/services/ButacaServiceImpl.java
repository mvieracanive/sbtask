package com.example.etecsa.services;

import org.springframework.stereotype.Service;

import java.util.List;

import com.example.etecsa.entities.Butaca;
import com.example.etecsa.entities.Teatro;
import com.example.etecsa.repositories.IButacaRepo;
import com.example.etecsa.repositories.ITeatroRepo;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ButacaServiceImpl implements IButacaService {

    @Autowired
    private IButacaRepo repo;
    @Autowired
    private ITeatroRepo repot;

    @Override
    public Butaca salvar(Butaca obj) {
        return repo.save(obj);
    }

    @Override
    public List<Butaca> listar(Teatro teatro) {
        return repo.findByTeatro(teatro);
    }

    /*
     * @Override public List<Butaca> listarContratoNull(List<Butaca> fc) {
     * 
     * List<Butaca> nullf = repo.findByContratoNull(); for (int i = 0; i <
     * nullf.size(); i++) { Butaca f = nullf.get(i); f.setFlag(false); nullf.set(i,
     * f); }
     * 
     * for (int i = 0; i < fc.size(); i++) { Butaca f = fc.get(i); f.setFlag(true);
     * fc.set(i, f); }
     * 
     * nullf.addAll(fc); return nullf;
     * 
     * return null; }
     */

    @Override
    public void eliminarPorId(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Butaca buscarPorId(Long id) {
        Butaca b = repo.findById(id).get();
        return b;
    }

    @Override
    public Integer getNumberOfSoldButacasByTeatro(Long teatroid) {
        Teatro t = repot.findById(teatroid).get();
        List<Butaca> bs = repo.findByTeatro(t);
        Integer count = 0;
        for (int i = 0; i < bs.size(); i++) {
            Butaca b = bs.get(i);
            if (b.getVendida())
                count++;
        }
        return count;
    }

    @Override
    public Integer getNumberOfButacasFumadoresByTeatro(Long teatroid) {
        Teatro t = repot.findById(teatroid).get();
        List<Butaca> bs = repo.findByTeatro(t);
        Integer count = 0;
        for (int i = 0; i < bs.size(); i++) {
            Butaca b = bs.get(i);
            if (b.getFumador())
                count++;
        }
        return count;
    }

    @Override
    public Float getRecaudadoBySoldButacasByTeatro(Long teatroid) {
        Teatro t = repot.findById(teatroid).get();
        List<Butaca> bs = repo.findByTeatro(t);
        Float count = new Float(0);
        for (int i = 0; i < bs.size(); i++) {
            Butaca b = bs.get(i);
            if (b.getVendida())
                count += b.getPrecio();
        }
        return count;
    }
}