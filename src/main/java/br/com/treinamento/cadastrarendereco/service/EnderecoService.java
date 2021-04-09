package br.com.treinamento.cadastrarendereco.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinamento.cadastrarendereco.model.Cliente;
import br.com.treinamento.cadastrarendereco.model.Endereco;
import br.com.treinamento.cadastrarendereco.repository.EnderecoRepository;

@Service
@Transactional
public class EnderecoService {
    
	@Autowired
    private EnderecoRepository enderecoRepository;

	public List<Endereco> listAllEndereco(Cliente cliente) {
        return enderecoRepository.findByCliente(cliente);
	}

    public void saveEndereco(Endereco endereco) {
    	enderecoRepository.save(endereco);
    }

    public Endereco getEndereco(Integer id, Cliente cliente) {
//        return enderecoRepository.findById(id).get();
        return enderecoRepository.findByIdAndCliente(id, cliente).get();
    }

    public void deleteEndereco(Integer id) {
    	enderecoRepository.deleteById(id);
    }
}