package br.com.everis.projetobeca.locadora.service;

import br.com.everis.projetobeca.locadora.model.Cliente;
import br.com.everis.projetobeca.locadora.model.Pedido;
import br.com.everis.projetobeca.locadora.model.Produto;

import java.util.List;

public interface PedidoService {

    //Ações bd pedido
    public List<Pedido> findAll();
    public Pedido findById(Long id);
    public Pedido save(Pedido pedido);

    //ações pedido
    public Pedido adicionarClienteAoPedido(Long idClientes);
    public Pedido adicionarProdutosAoPedido(Long idProduto);
    public Pedido criarPedido();
    public void concluirPedido(Pedido pedido);
}
