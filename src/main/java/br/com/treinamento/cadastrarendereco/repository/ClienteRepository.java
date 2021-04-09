package br.com.treinamento.cadastrarendereco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinamento.cadastrarendereco.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
}