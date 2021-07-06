package com.example.etecsa.repositories;

import java.util.List;

import com.example.etecsa.entities.Butaca;
import com.example.etecsa.entities.Teatro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IButacaRepo extends JpaRepository<Butaca, Long> {
    public List<Butaca> findByTeatro(Teatro teatro);
}