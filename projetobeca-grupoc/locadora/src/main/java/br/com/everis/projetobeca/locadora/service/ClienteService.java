package br.com.everis.projetobeca.locadora.service;

import br.com.everis.projetobeca.locadora.model.Cliente;
import ch.qos.logback.core.net.server.Client;

import java.util.List;

public interface ClienteService {

    List<Cliente>findAll();
    Cliente findById(Long id);
    Cliente save(Cliente cliente);


}
