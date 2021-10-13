package br.com.everis.projetobeca.locadora.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "FUNCIONARIOS")
@Data
@NoArgsConstructor
public class Funcionario  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Pedido> listaPedidos;

    @Column(nullable = false, unique = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false, unique = true)
    private String senha;

}