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
import com.example.etecsa.entities.Teatro;
import com.example.etecsa.services.ITeatroService;
import com.example.etecsa.services.IButacaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

@Controller
public class TeatroController {

    @Autowired
    private ITeatroService service;

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping(path = { "/teatro/blankform" })
    public ModelAndView create() {
        ModelAndView view = new ModelAndView("teatro-form");
        view.addObject("obj", new Teatro());

        return view;
    }

    @GetMapping(path = { "/teatro" })
    public ModelAndView listar(ModelAndView model) {
        model.setViewName("teatro-listar");
        model.addObject("obj", service.listar());

        return model;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @PostMapping("/teatro/save")
    public ModelAndView adicionar2(Teatro obj, ModelAndView model) {
        /*
         * if (obj.getId() == null) return model;
         */

        service.salvar(obj);
        model.setViewName("teatro-listar");
        model.addObject("obj", service.listar());
        return model;
    }

    /*
     * @GetMapping("/teatro/addbutacaform/{id}") public ModelAndView
     * addfactura(@PathVariable(name = "id") Long id, ModelAndView model) {
     * model.setViewName("addbutaca-form"); // service.salvar(obj); Contrato c =
     * service.buscarPorId(id); model.addObject("butaca", c);
     * model.addObject("butacas", servicef.listarContratoNull(c.getButacas()));
     * 
     * return model; }
     * 
     * @PostMapping("/contrato/saveFacturas/{id}") public ModelAndView
     * savefacturas(@PathVariable(name = "id") Long id, Contrato contrato,
     * ModelAndView model) { model.setViewName("contrato-listar");
     * model.addObject("obj", service.listar()); Contrato c =
     * service.buscarPorId(id); // c.setFacturas(contrato.getFacturas());
     * 
     * if (c.getId() == null) return model;
     * 
     * List<Factura> oldfacturas = c.getFacturas(); for (int i = 0; i <
     * oldfacturas.size(); i++) { Factura f = oldfacturas.get(i);
     * f.setContrato(null); servicef.salvar(f); } // service.salvar(c);
     * 
     * List<Factura> facturas = contrato.getFacturas();
     * 
     * for (int i = 0; i < facturas.size(); i++) { Factura f = facturas.get(i);
     * f.setContrato(c); servicef.salvar(f); } return model; }
     */

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/teatro/update/{id}")
    public ModelAndView editar(@PathVariable(name = "id") Long id, ModelAndView view) {
        view.setViewName("teatro-form");
        view.addObject("obj", service.buscarPorId(id));

        return view;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/teatro/delete/{id}")
    public ModelAndView eliminar(@PathVariable(name = "id") Long id, ModelAndView view) {
        service.eliminarPorId(id);
        view.setViewName("principal");
        view.addObject("obj", service.listar());

        return view;
    }

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