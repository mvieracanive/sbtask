package com.example.etecsa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.etecsa.entities.Butaca;
import com.example.etecsa.entities.Factura;
import com.example.etecsa.services.IButacaService;
import com.example.etecsa.services.ITeatroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

@Controller
public class ButacaController {

    @Autowired
    private IButacaService service;

    @Autowired
    private ITeatroService servicet;

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping(path = { "/butaca/blankform/{id}" })
    public ModelAndView create(@PathVariable(name = "id") Long teatro) {
        ModelAndView view = new ModelAndView("butaca-form");
        view.addObject("obj", new Butaca());
        view.addObject("teatro", servicet.buscarPorId(teatro));

        return view;
    }

    @GetMapping("/butaca/{id}")
    public ModelAndView listar(@PathVariable(name = "id") Long teatro, ModelAndView model) {
        model.setViewName("butaca-listar");
        model.addObject("obj", service.listar(servicet.buscarPorId(teatro)));
        model.addObject("teatro", servicet.buscarPorId(teatro));
        return model;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @PostMapping("/butaca/save/{id}")
    public ModelAndView adicionar2(Butaca obj, @PathVariable(name = "id") Long teatro, ModelAndView model) {
        model.setViewName("teatro-listar");
        obj.setTeatro(servicet.buscarPorId(teatro));
        if (obj.getPlatea()) {
            obj.setBalcon(null);
            obj.setFumador(null);
        } else {
            obj.setProtocolo(null);
        }
        service.salvar(obj);
        model.addObject("obj", servicet.listar());

        return model;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/butaca/update/{id}/{teatro}")
    public ModelAndView editar(@PathVariable(name = "id") Long id, @PathVariable(name = "teatro") Long teatro,
            ModelAndView view) {
        view.setViewName("butaca-form");
        Butaca b = service.buscarPorId(id);
        view.addObject("teatro", servicet.buscarPorId(teatro));
        b.setTeatro(servicet.buscarPorId(teatro));
        view.addObject("obj", b);

        return view;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/butaca/delete/{id}/{teatro}")
    public ModelAndView eliminar(@PathVariable(name = "id") Long id, @PathVariable(name = "teatro") Long teatro,
            ModelAndView model) {
        // Butaca b = service.buscarPorId(id);
        model.setViewName("teatro-listar");
        model.addObject("obj", servicet.listar());
        service.eliminarPorId(id);

        return model;
    }

    @GetMapping("/butaca/vender/{id}/{teatro}")
    public ModelAndView vender(@PathVariable(name = "id") Long id, @PathVariable(name = "teatro") Long teatro,
            ModelAndView model) {
        Butaca b = service.buscarPorId(id);
        b.setVendida(true);
        service.salvar(b);
        model.setViewName("butaca-listar");
        model.addObject("obj", service.listar(servicet.buscarPorId(teatro)));
        model.addObject("teatro", servicet.buscarPorId(teatro));
        return model;
    }
    /*
     * @GetMapping("/factura/update/{id}") public ModelAndView
     * editar(@PathVariable(name = "id") Long id, ModelAndView view) {
     * view.setViewName("factura-form"); view.addObject("obj",
     * service.buscarPorId(id));
     * 
     * return view; }
     * 
     * @GetMapping("/factura/delete/{id}") public ModelAndView
     * eliminar(@PathVariable(name = "id") Long id, ModelAndView view) {
     * service.eliminarPorId(id); view.setViewName("factura-listar");
     * view.addObject("obj", service.listar());
     * 
     * return view; }
     */

    /*
     * @GetMapping("/formduracion") public String showFormDuracion() { return
     * "peliculastiempomenorque"; }
     * 
     * @PostMapping("/listarpeliculasduracion") public ModelAndView
     * peliculasDuracion(int duracion, ModelAndView view) {
     * view.setViewName("peliculastiempomenorque"); view.addObject("peliculas",
     * service.findByDuracionLessThan(duracion));
     * 
     * return view; }
     */

    /*
     * @PostMapping("/adicionar2") public ModelAndView adicionar(Factura pelicula,
     * ModelAndView model) { model.addObject("peliculaFormulario", new Factura());
     * model.setViewName("factura-form");
     * 
     * service.salvar(pelicula);
     * 
     * return model; }
     */
}