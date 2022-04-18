package br.com.projeto.spring.projetosb.controllers;

import org.springframework.web.bind.annotation.*;

// define que vai ser um controller REST
@RestController
// aqui definimos um path para o controller
@RequestMapping("/metodos")
public class MetodosHttpController {

    // aqui definimos o get para a url metodos
    @GetMapping
    public String get() {
        return "Requisição GET";
    }

    // aqui definimos o post para a url metodos
    @PostMapping
    public String post() {
        return "Requisição POST";
    }

    // aqui definimos o put para a url metodos
    @PutMapping
    public String put() {
        return "Requisição PUT";
    }

    // aqui definimos o patch para a url metodos
    @PatchMapping
    public String patch() {
        return "Requisição PATCH";
    }

    // aqui definimos o delete para a url metodos
    @DeleteMapping
    public String delete() {
        return "Requisição DELETE";
    }

    // COMO não foi configurado uma sub rota na url
    // metodos ele vai pegar por padrão o tipo
    // da requisição

}
