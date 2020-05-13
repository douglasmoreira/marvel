package br.com.zup.marvel.mock;

import java.util.HashMap;
import java.util.Map;

import br.com.zup.marvel.entity.Cliente;

public class Mock {
	
	private Mock() {
	}
	
	public static Map<String, Cliente> criaListaDeDadosMock() {
		Map<String, Cliente> listaDeClientes = new HashMap<String, Cliente>();
		String nome = "joão";
		int idade = 24;
		String cpf = "1234567890";
		String email = "joaõ@zup.com.br";
		String telefone = "987654321";
		String endereco = "zico felix";
		
		String nome2 = "bráulio";
		int idade2 = 26;
		String cpf2 = "0123456789";
		String email2 = "bráulio@zup.com.br";
		String telefone2 = "987654321";
		String endereco2 = "zico frederico rocha";
		
		Cliente cliente = new Cliente(nome, idade, cpf, email, telefone, endereco);
		Cliente cliente2 = new Cliente(nome2, idade2, cpf2, email2, telefone2, endereco2);
		
		listaDeClientes.put(cpf, cliente);
		listaDeClientes.put(cpf2, cliente2);
		
		return listaDeClientes;
	}

	
	
}
