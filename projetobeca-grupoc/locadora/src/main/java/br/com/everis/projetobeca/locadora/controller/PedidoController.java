package br.com.everis.projetobeca.locadora.controller;

import br.com.everis.projetobeca.locadora.model.Cliente;
import br.com.everis.projetobeca.locadora.model.Funcionario;
import br.com.everis.projetobeca.locadora.model.Pedido;
import br.com.everis.projetobeca.locadora.model.Produto;
import br.com.everis.projetobeca.locadora.service.ClienteService;
import br.com.everis.projetobeca.locadora.service.FuncionarioService;
import br.com.everis.projetobeca.locadora.service.PedidoService;
import br.com.everis.projetobeca.locadora.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(value = "/pedidos", method = RequestMethod.GET)
    public ModelAndView buscarPedidos() {
        ModelAndView mv = new ModelAndView("pedidos");
        List<Pedido> pedidos = pedidoService.findAll();
        mv.addObject("pedidos", pedidos);
        return mv;
    }

    @RequestMapping(value = "/novopedido", method = RequestMethod.GET)
    public ModelAndView getPedidoForm() {
        Pedido pedido = pedidoService.criarPedido();

//        List<Cliente> listaClientes = clienteService.findAll();

        ModelAndView mv = new ModelAndView("pedidoForm");
        mv.addObject("pedido", pedido);
        //      mv.addObject("clientes", listaClientes);

        return mv;
    }

    @RequestMapping(value = "/adicionarproduto", method = RequestMethod.GET)
    public ModelAndView adicionarProdutoAoPedido(){
        ModelAndView mv = new ModelAndView("adicionarProdutoAoPedido");

        List<Produto> listaProdutos = produtoService.findAll();

        mv.addObject("produtos", listaProdutos);

        return mv;
    }

    @RequestMapping(value = "/pedido/addProduto/{produtoId}", method = RequestMethod.GET)
    public String addProdutoNoCarrinho(@PathVariable("produtoId") Long produtoId){
        pedidoService.adicionarProdutosAoPedido(produtoId);

        return "redirect:/novopedido";
    }

// --------------------------------------------------------------------------------------------

    @RequestMapping(value = "/adicionarcliente", method = RequestMethod.GET)
    public ModelAndView adicionarClienteAoPedido(){
        ModelAndView mv = new ModelAndView("adicionarClienteAoPedido");

        List<Cliente> listaClientes = clienteService.findAll();

        mv.addObject("clientes", listaClientes);

        return mv;
    }


    @RequestMapping(value = "/pedido/addCliente/{clienteId}", method = RequestMethod.GET)
    public String addClienteNoCarrinho(@PathVariable("clienteId") Long clienteId){
        pedidoService.adicionarClienteAoPedido(clienteId);

        return "redirect:/novopedido";
    }




    @RequestMapping(value = "/novopedido", method = RequestMethod.POST)
    public String concluirPedido(Pedido pedido) {
        pedidoService.concluirPedido(pedido);

        return "redirect:/pedidos";
    }
}
