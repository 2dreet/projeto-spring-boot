package br.com.projeto.spring.projetosb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Define que a classe vai ser um controller
@RestController
public class PrimeiroController {

    // aqui define que a função vai ser um recurso
    // a propiedade method define qual tipo vai ser (GET/POST/PUT/DELETE)
    // a propiedade path define a rota da função
    @RequestMapping(method = RequestMethod.GET, path = "/teste")
    public String ola() {
        return "Olá Spring Boot!";
    }
}
