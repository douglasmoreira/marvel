package br.com.zup.marvel.mock;

import java.util.HashMap;
import java.util.Map;

import br.com.zup.marvel.entity.Cliente;

public class Mock {
	
	private Mock() {
	}
	
	public static Map<String, Cliente> criaListaDeDadosMock() {
		Map<String, Cliente> listaDeClientes = new HashMap<String, Cliente>();
		Cliente cliente = new Cliente();
		Cliente cliente2 = new Cliente();
		cliente.setNome("joão");
		cliente.setIdade(24);
		cliente.setCpf("1234567890");
		cliente.setEmail("joaõ@zup.com.br");
		cliente.setTelefone("987654321");
		cliente.setEndereco("zico felix");
		
		
		cliente2.setNome("bráulio");
		cliente2.setIdade(26);
		cliente2.setCpf("0123456789");
		cliente2.setEmail("bráulio@zup.com.br");
		cliente2.setTelefone("987654321");
		cliente2.setEndereco("zico frederico rocha");		
		
		listaDeClientes.put(cliente.getCpf(), cliente);
		listaDeClientes.put(cliente2.getCpf(), cliente2);
		
		return listaDeClientes;
	}

	
	
}
