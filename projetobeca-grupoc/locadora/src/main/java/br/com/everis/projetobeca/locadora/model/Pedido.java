package br.com.everis.projetobeca.locadora.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "PEDIDOS")
@Data
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinColumn(referencedColumnName = "idCliente", name = "idCliente")
    private List<Cliente> clientes = new ArrayList<>();

    @Column(nullable = false, unique = false)
    private StatusPedido status = StatusPedido.ABERTO;

    @ManyToMany
    @JoinColumn(referencedColumnName = "idProduto", name = "idPedido")
    private List<Produto> produtos = new ArrayList<>();

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate data;

    private Double tempoDeLocacao;

    private Double valorTotal;

    private  FormaPagamento formaPagamento;

}
