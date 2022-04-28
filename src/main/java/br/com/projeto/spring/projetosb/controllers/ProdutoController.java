package br.com.projeto.spring.projetosb.controllers;

import br.com.projeto.spring.projetosb.model.entities.Produto;
import br.com.projeto.spring.projetosb.model.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

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
    public @ResponseBody Produto novoProduto(
            @RequestParam String nome,
            @RequestParam Double preco,
            @RequestParam Double desconto
    ) {
        Produto produto = new Produto(nome, preco, desconto);
        // aqui salvamos a model no banco
        produtoRepository.save(produto);
        return produto;
    }

    // aqui definimos que vai ser uma rota do tipo post
    @PostMapping("/json")
    // @ResponseBody definimos que a model Produto que vai ser retornada
    // Aqui definimos que vai receber um produto
    public @ResponseBody Produto novoProdutoJson(
            @Valid Produto produto
    ) {
        // aqui salvamos a model no banco
        produtoRepository.save(produto);
        return produto;
    }

    // aqui definimos o retorno de todos os produtos
    @GetMapping
    public @ResponseBody Iterable<Produto> obterTodosProdutos() {
        return produtoRepository.findAll();
    }
    
 // aqui definimos o retorno de todos os produtos
    @GetMapping(path = "/pagina/{pagina}/{total}")
    public @ResponseBody Iterable<Produto> obterProdutos( 
    		@PathVariable int pagina,
    		@PathVariable int total) {
    	
    	// aqui criamos a paginacao com Pageable
    	Pageable page = PageRequest.of(pagina, total); 
        return produtoRepository.findAll(page);
    }
    
    @GetMapping(path = "/nome/{parteNome}")
    public @ResponseBody Iterable<Produto> obterProdutoParteNome(@PathVariable String parteNome) {
//    	return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
    	return produtoRepository.searchByNameLike(parteNome);
    }
    
    @GetMapping(path = "/preco/{preco}")
    public @ResponseBody Iterable<Produto> obterProdutoPrecoMenorQue(@PathVariable double preco) {
//    	return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
    	return produtoRepository.searchProdutosPrecoMenorQue(preco);
    }

    // aqui definimos o retorno por id
    @GetMapping("/unico")
    public @ResponseBody Optional<Produto> obterProdutoPorId(@RequestParam(name = "id") Long id ) {
        return produtoRepository.findById(id);
    }

    // aqui definimos o retorno por id por path
    @GetMapping("/{id}")
    public @ResponseBody Optional<Produto> obterProdutoPorIdPath(@PathVariable Long id ) {
        return produtoRepository.findById(id);
    }

    // aqui definimos o metodo put para alteração
    @PutMapping
    public @ResponseBody Produto alterarProduto(@Valid Produto produto){
        produtoRepository.save(produto);
        return produto;
    }

    // aqui definimos 2 tipos de resquest para o mesma função
    @RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT}, path = "/enviar")
    public @ResponseBody Produto receberProduto(@Valid Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    // aqui definimos o delete com parametro
    @DeleteMapping
    public void removerProduto(@RequestParam(name = "id") Long id){
        produtoRepository.deleteById(id);
    }

    // aqui definimos o delete com path parametro
    @DeleteMapping(path = "/{id}")
    public void removerProdutoPath(@PathVariable Long id){
        produtoRepository.deleteById(id);
    }
    
    
}
