package br.com.everis.projetobeca.locadora.service;

import br.com.everis.projetobeca.locadora.model.Funcionario;

import java.util.List;

public interface FuncionarioService {

    List<Funcionario> findAll();
    Funcionario findById(Long id);
    Funcionario save(Funcionario funcionario);
}
