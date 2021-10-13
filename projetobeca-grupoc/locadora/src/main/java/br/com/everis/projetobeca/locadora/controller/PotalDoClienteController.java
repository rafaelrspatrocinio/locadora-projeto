package br.com.everis.projetobeca.locadora.controller;

import br.com.everis.projetobeca.locadora.model.Cliente;
import br.com.everis.projetobeca.locadora.model.Produto;
import br.com.everis.projetobeca.locadora.service.ClienteService;
import br.com.everis.projetobeca.locadora.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PotalDoClienteController {

    @Autowired
    ProdutoService produtoService;

    @RequestMapping(value = "/portalcliente", method = RequestMethod.GET)
    public ModelAndView paginaPrincipalCliente(){
        ModelAndView mv = new ModelAndView("portalcliente");
        List<Produto> produtos = produtoService.findAll();
        mv.addObject("produtos", produtos);
        return mv;
    }

}


