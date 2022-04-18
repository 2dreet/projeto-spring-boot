package br.com.projeto.spring.projetosb.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("calculadora")
public class CalculadoraController {

    // aqui definimos a url com path variaveis
    // ex: http://localhost:8080/calculadora/somar/15.5/7.2
    @GetMapping("/somar/{a}/{b}")
    public Double somar(
            @PathVariable double a,
            @PathVariable double b) {
        return a + b;
    }

    // aqui definimos uma url com paramatros
    // ex: http://localhost:8080/calculadora/subtrair?a=15.5&b=7.2
    @GetMapping("/subtrair")
    public Double subtrair(
            @RequestParam(name = "a") double a,
            @RequestParam(name = "b") double b) {
        return a - b;
    }
}
