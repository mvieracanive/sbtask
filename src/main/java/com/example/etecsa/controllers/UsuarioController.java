package com.example.etecsa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.etecsa.entities.Contrato;
import com.example.etecsa.entities.Factura;
import com.example.etecsa.entities.Usuario;
import com.example.etecsa.services.ITeatroService;
import com.example.etecsa.services.IUsuarioService;
import com.example.etecsa.services.IButacaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

@Controller
public class UsuarioController {
    @Autowired
    private IUsuarioService service;

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping(path = { "/usuario/blankform" })
    public ModelAndView create() {
        ModelAndView view = new ModelAndView("usuario-form");
        view.addObject("obj", new Usuario());

        return view;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping(path = { "/usuario" })
    public ModelAndView listar(ModelAndView model) {
        model.setViewName("usuario-listar");
        model.addObject("obj", service.findAll());

        return model;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @PostMapping("/usuario/save")
    public ModelAndView adicionar2(Usuario obj, ModelAndView model) {
        /*
         * if (obj.getId() == null) return model;
         */

        service.salvar(obj);
        model.setViewName("usuario-listar");
        model.addObject("obj", service.findAll());
        return model;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/usuario/update/{id}")
    public ModelAndView editar(@PathVariable(name = "id") Long id, ModelAndView view) {
        view.setViewName("usuario-form");
        view.addObject("obj", service.findById(id));

        return view;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/usuario/delete/{id}")
    public ModelAndView eliminar(@PathVariable(name = "id") Long id, ModelAndView view) {
        service.eliminar(id);
        view.setViewName("usuario-listar");
        view.addObject("obj", service.findAll());

        return view;
    }
}
