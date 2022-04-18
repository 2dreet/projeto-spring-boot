package br.com.projeto.spring.projetosb.controllers;

import br.com.projeto.spring.projetosb.models.Cliente;
import org.springframework.web.bind.annotation.*;

// define um controller em uma api Rest
@RestController
// aqui define que a o controller vai ser mapeado no path
// e todas as outras rotas vao ser apartir dessa rota configurada
@RequestMapping(path = "/clientes")
public class ClienteController {

    @GetMapping( path = { "/qualquer" })
    public Cliente obterCliente(){
        return new Cliente(1, "Jose", "014.258.369-87");
    }

    // aqui definimos um parametro na url {nome} -> indica que vai ser um parametro
    @GetMapping("/{id}")
    // @PathVariable indica que vai ser um parametro da url
    public Cliente obterClienteId(@PathVariable int id){
        return new Cliente(id, "José", "111");
    }

    //Aqui usamos o query string parametros
    @GetMapping
    // aqui o @RequestParam configura os parametros da url
    // ex: http://localhost:8080/clientes?id=121
    // o defaultValue serve para quando não enviar nada pega um valor por padrao
    public Cliente obterClienteId2(
            @RequestParam(name = "id", defaultValue = "1") int id) {
        return new Cliente(id, "José Augusto", "222");
    }
}
