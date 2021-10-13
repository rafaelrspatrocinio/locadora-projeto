package br.com.everis.projetobeca.locadora.controller;

import br.com.everis.projetobeca.locadora.model.Cliente;
import br.com.everis.projetobeca.locadora.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public ModelAndView buscarCliente(){
        ModelAndView mv = new ModelAndView("clientes");
        List<Cliente> clientes = clienteService.findAll();
        mv.addObject("clientes", clientes);
        return mv;
    }

    @RequestMapping(value = "/novocliente", method = RequestMethod.GET)
    public String getClienteForm(){
        return "clienteForm";
    }

    @RequestMapping(value = "/novocliente", method = RequestMethod.POST)
    public String saveCliente(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors() ) {
            attributes.addFlashAttribute("messagem", "Verifique de os campos obrigatórios foram preenchidos");
            return "redirect:/novocliente";
        }
        clienteService.save(cliente);
        return "redirect:/clientes";
    }
}


