package br.com.everis.projetobeca.locadora.controller.dto;

import br.com.everis.projetobeca.locadora.model.Funcionario;

import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioDTO {

    private Long id;
    private String nome;
    private String login;
    private String senha;

    public FuncionarioDTO(Funcionario funcionario) {
        this.nome = funcionario.getNome();
        this.login = funcionario.getLogin();
        this.senha = funcionario.getSenha();
    }

    public List<FuncionarioDTO> converterFuncionarios(List<Funcionario> funcionarios){
        return funcionarios.stream().map(FuncionarioDTO::new).collect(Collectors.toList());
    }
}
