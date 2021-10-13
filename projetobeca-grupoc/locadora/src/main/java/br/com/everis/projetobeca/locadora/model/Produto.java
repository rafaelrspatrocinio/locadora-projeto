package br.com.everis.projetobeca.locadora.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "PRODUTOS")
@Data
@NoArgsConstructor
public class Produto {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(nullable = false, unique = false)
   private String nome;

   @Lob //usado para o banco aceitar valores grandes e tratar com melhor performance
   @Column(nullable = false, unique = false)
   private String descricao;

   @Column(nullable = false, unique = false)
   private Double preco;

}
