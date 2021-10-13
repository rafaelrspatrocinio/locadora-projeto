package br.com.everis.projetobeca.locadora.service.impl;

import br.com.everis.projetobeca.locadora.model.Produto;
import br.com.everis.projetobeca.locadora.repository.ProdutoRepository;
import br.com.everis.projetobeca.locadora.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto findById(Long id) {
        return produtoRepository.findById(id).get();
    }

    @Override
    public Produto save(Produto produto) {
        if (verificarPreco(produto)){
            return produtoRepository.save(produto);
        }
        return null;
    }

    public boolean verificarPreco(Produto produto){
        if (produto.getPreco() == null || produto.getPreco() < 0){
            produto.setPreco(0.0);
            return false;
        }
        return true;
    }
}
