package br.com.everis.projetobeca.locadora.repository;

import br.com.everis.projetobeca.locadora.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
