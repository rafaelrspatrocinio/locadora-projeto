package br.com.everis.projetobeca.locadora.service.impl;

import br.com.everis.projetobeca.locadora.model.Cliente;
import br.com.everis.projetobeca.locadora.model.Pedido;
import br.com.everis.projetobeca.locadora.model.Produto;
import br.com.everis.projetobeca.locadora.repository.PedidoRepository;
import br.com.everis.projetobeca.locadora.service.ClienteService;
import br.com.everis.projetobeca.locadora.service.PedidoService;
import br.com.everis.projetobeca.locadora.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@Scope(value= WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PedidoServiceImpl implements PedidoService {

    private Pedido pedido;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;


    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).get();
    }

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido adicionarClienteAoPedido(Long idCliente){
        Cliente cliente = clienteService.findById(idCliente);

        this.pedido.getClientes().add( cliente );

        return pedido;
    }

    public Pedido adicionarProdutosAoPedido(Long idProduto){
        Produto produto = produtoService.findById(idProduto);

        this.pedido.getProdutos().add( produto );

        return pedido;
    }

    public Pedido criarPedido(){
        if(Objects.isNull(pedido)) {
            this.pedido = new Pedido();
        }

        return pedido;
    }

    public void concluirPedido(Pedido pedido){
        pedido.setProdutos(this.criarPedido().getProdutos());
        pedido.setData(LocalDate.now());
        this.save(pedido);

        this.pedido = null;
    }
}
