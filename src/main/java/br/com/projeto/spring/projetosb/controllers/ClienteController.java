package br.com.projeto.spring.projetosb.controllers;

import br.com.projeto.spring.projetosb.models.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// define um controller em uma api Rest
@RestController
// aqui define que a o controller vai ser mapeado no path
// e todas as outras rotas vao ser apartir dessa rota configurada
@RequestMapping(path = "/clientes")
public class ClienteController {

    @GetMapping( path = { "/" })
    public Cliente obterCliente(){
        return new Cliente(1, "Jose", "014.258.369-87");
    }
}
