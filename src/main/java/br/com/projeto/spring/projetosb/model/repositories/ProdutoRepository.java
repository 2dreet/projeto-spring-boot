package br.com.projeto.spring.projetosb.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.projeto.spring.projetosb.model.entities.Produto;
// aqui criamos a interface PagingAndSortingRepository de Produto
// PagingAndSortingRepository _> server para ter consultas paginadas e
// consultas ordenadas alem do crud
// a classe CrudRepository é responsavel por gerenciar a model com o banco
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long> {
	
	//findBy + Atributo + Containig
	//findBy + Atributo + IsContainig
	//findBy + Atributo + Contains
	
	//findBy + Atributo + StartWith
	//findBy + Atributo + EndsWith
	
	//findBy + Atributo + NotContaining
	
	
	// Aqui criamos uma busca personializada por nome
	// deve seguir o padrao findBy + nome do atributo + como vai ser
	// nesse caso usamos o Containing que serve como o like 
	// o IgnoreCase serve para ignora Letras maiusculas e minusculas
	public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);
	
	
	// Aqui criamos uma consulta por query com JPQL
	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> searchByNameLike(@Param("nome") String nome);
	
	@Query("SELECT p FROM Produto p WHERE p.preco <= :preco")
	public Iterable<Produto> searchProdutosPrecoMenorQue(@Param("preco") double preco);
	
	
	
}
