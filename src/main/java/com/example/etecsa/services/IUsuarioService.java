package com.example.etecsa.services;

import java.util.List;

import com.example.etecsa.entities.Usuario;

public interface IUsuarioService {

    public Usuario salvar(Usuario usuario);

    public Usuario findById(Long id);

    public Usuario findByName(String nombre);

    public List<Usuario> findAll();

    public void eliminar(Long id);

}