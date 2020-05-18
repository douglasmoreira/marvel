package br.com.zup.marvel.Service;

import java.util.ArrayList;
import java.util.List;

import br.com.zup.marvel.dao.ClienteDAO;
import br.com.zup.marvel.entity.Cliente;
import br.com.zup.marvel.mock.Mock;

public class ClienteService {
	
	ClienteDAO clienteDAO = new ClienteDAO();

	public Cliente insereCliente(Cliente cliente) {
		Mock.criaListaDeDadosMock().put(cliente.getCpf(), cliente);
		
		clienteDAO.insert(cliente);
		return Mock.criaListaDeDadosMock().get(cliente.getCpf());
	}

	public  Cliente atualizaCliente(Cliente cliente, String cpf) {

		Mock.criaListaDeDadosMock().put(cpf, cliente);
		
		clienteDAO.update(cliente);
		
		return Mock.criaListaDeDadosMock().get(cpf);
	}

	public List<Cliente> retornaClientes(String cpf) {

		if (cpf != null) {
			ArrayList<Cliente> clienteList = new ArrayList<Cliente>();
			clienteList.add(clienteDAO.findByCpf(cpf));
			return clienteList;
		} else {
			
			return clienteDAO.findAll();
		}
	}

	public void deleta(String cpf) {

		clienteDAO.remove(cpf);
	}

}
