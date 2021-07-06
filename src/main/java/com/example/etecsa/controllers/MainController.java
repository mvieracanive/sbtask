package com.example.etecsa.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(path = { "/login", "/index" })
    public String login() {
        return "login";
    }

    @GetMapping(path = { "/principal", "/" })
    public String success(HttpSession session, Model model) {
        SecurityContext ctx = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
        Authentication auth = ctx.getAuthentication();// aqui está toda la informacion del user
        return "principal";
    }
}