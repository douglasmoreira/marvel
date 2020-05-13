package br.com.zup.marvel.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.com.zup.marvel.entity.Cliente;
import br.com.zup.marvel.mock.Mock;

public class ClienteService {
	
	private static Map<String, Cliente> listaDeClientes;

	public Cliente insereCliente(Cliente cliente) {
		listaDeClientes = new HashMap<>();
		listaDeClientes.put(cliente.getCpf(), cliente);

		return listaDeClientes.get(cliente.getCpf());
	}

	public  Cliente atualizaCliente(Cliente cliente) {

		listaDeClientes.put(cliente.getCpf(), cliente);
		
		return listaDeClientes.get(cliente.getCpf());
	}

	public List<Cliente> retornaClientes(String cpf) {

		if (cpf != null) {
			ArrayList<Cliente> clienteList = new ArrayList<Cliente>();
			listaDeClientes = Mock.criaListaDeDadosMock();
			clienteList.add(listaDeClientes.get(cpf));
			return clienteList;
		} else {
			ArrayList<Cliente> clienteList = new ArrayList<Cliente>(Mock.criaListaDeDadosMock().values());
			return clienteList;
		}
	}

	public void deleta(String cpf) {

		listaDeClientes.remove(cpf);
	}

}
