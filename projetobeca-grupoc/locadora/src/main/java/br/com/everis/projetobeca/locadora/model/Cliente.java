package br.com.everis.projetobeca.locadora.model;

import lombok.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "CLIENTES")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false)
    private String nome;

    @Column(nullable = true, unique = false)
    private String telefone;

    @Column(nullable = false, unique = false, length = 11)
    private String cpf;

    @Column(nullable = false, unique = false)
    private String email;

    @Column(nullable = false, unique = false)
    private String endereco;

    @Column(nullable = false, unique = false)
    private String login;

    @Column(nullable = false, unique = false)
    private String senha;

    @OneToOne(cascade = CascadeType.ALL) //cria um vinculo na exclusão
    private Pedido pedido;
}


