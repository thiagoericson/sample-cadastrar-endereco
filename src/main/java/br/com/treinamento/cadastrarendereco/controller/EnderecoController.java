package br.com.treinamento.cadastrarendereco.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.cadastrarendereco.model.Cliente;
import br.com.treinamento.cadastrarendereco.model.Endereco;
import br.com.treinamento.cadastrarendereco.service.ClienteService;
import br.com.treinamento.cadastrarendereco.service.EnderecoService;

@RestController
@RequestMapping("/clientes/{idCliente}/enderecos")
public class EnderecoController {

	@Autowired
    ClienteService clienteService;

    @Autowired
    EnderecoService enderecoService;

    @GetMapping("")
    public List<Endereco> list(@PathVariable Integer idCliente) {
    	Cliente cliente = clienteService.getCliente(idCliente);
        return enderecoService.listAllEndereco(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> get(@PathVariable Integer idCliente, @PathVariable Integer id) {
        try {
        	Cliente cliente = clienteService.getCliente(idCliente);
            Endereco endereco = enderecoService.getEndereco(id, cliente);
            return new ResponseEntity<Endereco>(endereco, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Endereco>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody Endereco endereco, @PathVariable Integer idCliente) {
    	Cliente cliente = clienteService.getCliente(idCliente);
    	endereco.setCliente(cliente);
    	enderecoService.saveEndereco(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Endereco endereco, @PathVariable Integer idCliente, @PathVariable Integer id) {
        try {
        	Cliente cliente = clienteService.getCliente(idCliente);
            endereco.setId(id);
            endereco.setCliente(cliente);
        	enderecoService.saveEndereco(endereco);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer idCliente, @PathVariable Integer id) {
        try {
        	Cliente cliente = clienteService.getCliente(idCliente);
            enderecoService.getEndereco(id, cliente);
            enderecoService.deleteEndereco(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
