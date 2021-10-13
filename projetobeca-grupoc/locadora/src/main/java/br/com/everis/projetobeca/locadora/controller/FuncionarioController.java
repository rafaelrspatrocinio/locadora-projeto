package br.com.everis.projetobeca.locadora.controller;

import br.com.everis.projetobeca.locadora.model.Cliente;
import br.com.everis.projetobeca.locadora.model.Funcionario;
import br.com.everis.projetobeca.locadora.service.FuncionarioService;
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
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @RequestMapping(value = "/funcionarios", method = RequestMethod.GET)
    public ModelAndView buscarFuncionario(){
        ModelAndView mv = new ModelAndView("funcionarios");
        List<Funcionario> funcionarios = funcionarioService.findAll();
        mv.addObject("funcionarios", funcionarios);
        return mv;
    }

    @RequestMapping(value = "/novofuncionario", method = RequestMethod.GET)
    public String getFuncionarioForm(){
        return "funcionarioForm";
    }

    @RequestMapping(value = "/novofuncionario", method = RequestMethod.POST)
    public String saveFuncionario(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors() ) {
            attributes.addFlashAttribute("messagem", "Verifique de os campos obrigatórios foram preenchidos");
            return "redirect:/novofuncionario";
        }

        funcionarioService.save(funcionario);
        return "redirect:/funcionarios";
    }

}
