package br.com.zup.marvel.Service;

import java.util.ArrayList;
import java.util.List;

import br.com.zup.marvel.dao.ClienteDAO;
import br.com.zup.marvel.entity.Cliente;

public class ClienteService {
	
	ClienteDAO clienteDAO = new ClienteDAO();

	public Cliente insereCliente(Cliente cliente) {
		
		clienteDAO.insert(cliente);
		return cliente;
	}

	public  Cliente atualizaCliente(Cliente cliente, String cpf) {
		
		clienteDAO.update(cliente, cpf);
		cliente.setCpf(cpf);
		return cliente;
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
