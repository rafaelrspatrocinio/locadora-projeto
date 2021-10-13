package br.com.everis.projetobeca.locadora.controller.dto;

import br.com.everis.projetobeca.locadora.model.Produto;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Double preco;

    public ProdutoDTO(Produto produto) {
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
    }

    public List<ProdutoDTO> converterProdutos(List<Produto> produtos){
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList()); //pra cada produtoDTO chama um produto com parametro e adiciona em uma lista
    }
}
