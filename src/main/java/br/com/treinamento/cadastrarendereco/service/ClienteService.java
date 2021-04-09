package br.com.treinamento.cadastrarendereco.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinamento.cadastrarendereco.model.Cliente;
import br.com.treinamento.cadastrarendereco.repository.ClienteRepository;

@Service
@Transactional
public class ClienteService {
    
	@Autowired
    private ClienteRepository clienteRepository;
    
	public List<Cliente> listAllCliente() {
        return clienteRepository.findAll();
    }

    public void saveCliente(Cliente cliente) {
    	clienteRepository.save(cliente);
    }

    public Cliente getCliente(Integer id) {
        return clienteRepository.findById(id).get();
    }

    public void deleteCliente(Integer id) {
    	clienteRepository.deleteById(id);
    }
}