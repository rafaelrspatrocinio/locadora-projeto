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
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public ModelAndView buscarProduto(){
        ModelAndView mv = new ModelAndView("produtos");
        List<Produto> produtos = produtoService.findAll();
        mv.addObject("produtos", produtos);
        return mv;
    }

    @RequestMapping(value = "/novoproduto", method = RequestMethod.GET)
    public String getProdutoForm(){
        return "produtoForm";
    }

    @RequestMapping(value = "/novoproduto", method = RequestMethod.POST)
    public String saveProduto(@Valid Produto produto, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors() ) {
            attributes.addFlashAttribute("messagem", "Verifique de os campos obrigatórios foram preenchidos");
            return "redirect:/novoproduto";
        }

        produtoService.save(produto);
        return "redirect:/produtos";
    }
}


