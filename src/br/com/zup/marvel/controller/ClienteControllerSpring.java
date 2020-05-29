package br.com.zup.marvel.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.marvel.Service.ClienteService;
import br.com.zup.marvel.entity.Cliente;

@RestController
@RequestMapping
public class ClienteControllerSpring {

	@Autowired
	ClienteService clienteService;
	
	@PostMapping(path = "/cliente", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cliente post(@RequestBody Cliente cliente) {
		
		return clienteService.insereCliente(cliente);
	}
	
	@PutMapping(path = "/cliente/{cpf}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente put(@PathVariable String cpf, @RequestBody Cliente cliente) {
		
		return clienteService.atualizaCliente(cliente, cpf);
	}
	
	@GetMapping(path = "/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> get(@PathParam(value = "cpf") String cpf) {
		
		return clienteService.retornaClientes(cpf);
	}
	
	@DeleteMapping(path = "/cliente/{cpf}")
	public void delete(@PathVariable String cpf) {
		
		clienteService.deleta(cpf);
	}
 }
