package br.com.everis.projetobeca.locadora.repository;

import br.com.everis.projetobeca.locadora.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
