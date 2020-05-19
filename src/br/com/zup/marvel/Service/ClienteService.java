package br.com.zup.marvel.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.marvel.entity.Cliente;
import br.com.zup.marvel.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repository;

	public Cliente insereCliente(Cliente cliente) {
		
		return repository.save(cliente);
	}

	public  Cliente atualizaCliente(Cliente cliente, String cpf) {
		
		cliente.setCpf(cpf);
		return repository.save(cliente);
	}

	public List<Cliente> retornaClientes(String cpf) {

		if (cpf != null) {
			ArrayList<Cliente> clienteList = new ArrayList<Cliente>();
			clienteList.add(repository.findById(cpf).get());

			return clienteList;
		} else {
			
			return repository.findAll();
		}
	}

	public void deleta(String cpf) {

		repository.deleteById(cpf);
	}

}
