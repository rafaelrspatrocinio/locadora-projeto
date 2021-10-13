package br.com.everis.projetobeca.locadora.controller.dto;

import br.com.everis.projetobeca.locadora.model.Cliente;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ClienteDTO {

    private Long id;
    private String nome;
    private String telefone;
    private String cpf;
    private String email;
    private String endereco;
    private String login;
    private String senha;

    public ClienteDTO(Cliente cliente) {
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.endereco = cliente.getEndereco();
        this.login = cliente.getLogin();
        this.senha = cliente.getSenha();
    }

    public List<ClienteDTO> converterClientes(List<Cliente> clientes){
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }
}
