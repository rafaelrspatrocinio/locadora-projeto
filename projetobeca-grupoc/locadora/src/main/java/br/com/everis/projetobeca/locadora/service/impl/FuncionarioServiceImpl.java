package br.com.everis.projetobeca.locadora.service.impl;

import br.com.everis.projetobeca.locadora.model.Funcionario;
import br.com.everis.projetobeca.locadora.repository.FuncionarioRepository;
import br.com.everis.projetobeca.locadora.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario findById(Long id) {
        return funcionarioRepository.findById(id).get();
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }
}
