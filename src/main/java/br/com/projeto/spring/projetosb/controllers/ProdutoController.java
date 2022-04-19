package br.com.projeto.spring.projetosb.controllers;

import br.com.projeto.spring.projetosb.model.entities.Produto;
import br.com.projeto.spring.projetosb.model.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// aqui definimos que a classe vai ser um controller
@RestController
// definimos a rota para o controller
@RequestMapping("/produtos")
public class ProdutoController {

    // aqui definimos que vai ter uma injecao de dependencia do ProdutoRepository
    // o @Autowired faz a inicialização automatica da classe
    @Autowired
    private ProdutoRepository produtoRepository;

    // aqui definimos que vai ser uma rota do tipo post
    @PostMapping
    // @ResponseBody definimos que a model Produto que vai ser retornada
    // @ResquestParam definimos que vai ter um atributo nome no body da resquest
    public @ResponseBody Produto novoProduto(@RequestParam String nome) {
        Produto produto = new Produto(nome);
        // aqui salvamos a model no banco
        produtoRepository.save(produto);
        return produto;
    }
}
