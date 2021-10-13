package br.com.everis.projetobeca.locadora.repository;

import br.com.everis.projetobeca.locadora.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
