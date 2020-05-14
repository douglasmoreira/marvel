package br.com.zup.marvel.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.zup.marvel.dao.DAO;
import br.com.zup.marvel.entity.Cliente;
import br.com.zup.marvel.mock.Mock;

public class ClienteService {
	
	private static Map<String, Cliente> listaDeClientes;
	DAO dao = new DAO();

	public Cliente insereCliente(Cliente cliente) {
		listaDeClientes = new HashMap<>();
		listaDeClientes.put(cliente.getCpf(), cliente);
		

		dao.inserirCliente(cliente);
		return listaDeClientes.get(cliente.getCpf());
	}

	public  Cliente atualizaCliente(Cliente cliente) {

		Mock.criaListaDeDadosMock().put(cliente.getCpf(), cliente);
		dao.atualizaCliente(cliente.getCpf(), cliente);
		
		return Mock.criaListaDeDadosMock().get(cliente.getCpf());
	}

	public List<Cliente> retornaClientes(String cpf) {

		if (cpf != null) {
			ArrayList<Cliente> clienteList = new ArrayList<Cliente>();
			listaDeClientes = Mock.criaListaDeDadosMock();
			clienteList.add(dao.recuperaClientes(cpf));
			return clienteList;
		} else {
			ArrayList<Cliente> clienteList = new ArrayList<Cliente>(dao.recuperaListaDeClientes().values());
			
			return clienteList;
		}
	}

	public void deleta(String cpf) {

		dao.deletaCliente(cpf);
		Mock.criaListaDeDadosMock().remove(cpf);
	}

}
