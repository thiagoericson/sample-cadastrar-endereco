package br.com.treinamento.cadastrarendereco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinamento.cadastrarendereco.model.Cliente;
import br.com.treinamento.cadastrarendereco.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

	List<Endereco> findByCliente(Cliente cliente);
	Optional<Endereco> findByIdAndCliente(Integer id, Cliente cliente);

}
