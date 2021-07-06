package com.example.etecsa.repositories;

import com.example.etecsa.entities.Contrato;
import com.example.etecsa.entities.Teatro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeatroRepo extends JpaRepository<Teatro, Long> {
    // public List<Factura> findByDuracionLessThan(int duracion);
}