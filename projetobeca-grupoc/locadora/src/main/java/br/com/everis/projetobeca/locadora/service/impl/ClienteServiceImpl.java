package br.com.everis.projetobeca.locadora.service.impl;

import br.com.everis.projetobeca.locadora.model.Cliente;
import br.com.everis.projetobeca.locadora.repository.ClienteRepository;
import br.com.everis.projetobeca.locadora.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public Cliente save(Cliente cliente) {
        if (verificarCPF(cliente) && verificarNome(cliente) && verificarTelefone(cliente)){
            return clienteRepository.save(cliente);
        }
        return null;
    }

    public boolean verificarCPF(Cliente cliente){
        if (cliente.getCpf().length() != 11){
            return false;
        }
        return true;
    }

    public boolean verificarNome(Cliente cliente){
        if(cliente.getNome().contains("0") || cliente.getNome().contains("1") || cliente.getNome().contains("2") || cliente.getNome().contains("3") ||
                cliente.getNome().contains("4") || cliente.getNome().contains("5") || cliente.getNome().contains("6") || cliente.getNome().contains("7")||
                cliente.getNome().contains("8") || cliente.getNome().contains("9")){
            return false;
        }
        return true;
    }

    public boolean verificarTelefone(Cliente cliente){
        if (cliente.getTelefone() == null){
            return false;
        }
        for (char letra : cliente.getTelefone().toCharArray()){
            if(letra < '0' || letra > '9'){
                return false;
            }
        }
        return true;
    }
}
