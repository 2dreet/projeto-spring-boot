package br.com.projeto.spring.projetosb.model.repositories;

import br.com.projeto.spring.projetosb.model.entities.Produto;
import org.springframework.data.repository.CrudRepository;
// aqui criamos a interface CrudRepository de Produto
// a classe CrudRepository é responsavel por gerenciar a model com o banco
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}
