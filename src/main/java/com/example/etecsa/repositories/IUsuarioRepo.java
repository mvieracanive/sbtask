package com.example.etecsa.repositories;

import java.util.Optional;

import com.example.etecsa.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByUserName(String nombre);
}
