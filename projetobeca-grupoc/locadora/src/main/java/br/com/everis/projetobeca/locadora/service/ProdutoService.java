package br.com.everis.projetobeca.locadora.service;

import br.com.everis.projetobeca.locadora.controller.dto.ProdutoDTO;
import br.com.everis.projetobeca.locadora.model.Produto;

import java.util.List;

public interface ProdutoService {

    public List<Produto> findAll();
    public Produto findById(Long id);
    public Produto save(Produto produto);

}
