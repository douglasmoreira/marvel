package br.com.zup.marvel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.zup.marvel.entity.Cliente;

public class ProgramaPrincipal {

	private static Map<String, Cliente> listaDeClientes;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		listaDeClientes = new HashMap<String, Cliente>();

		int opcao = 0;
		do {

			System.out.println("Digite 1 para inserir um cliente. ");
			System.out.println("Digite 2 para imprimir um cliente.");
			System.out.println("Digite 3 para imprimir ou todos clientes.");
			System.out.println("Digite 4 para alterar um cliente pelo CPF:");
			System.out.println("Digite 5 para deletar um cliente pelo CPF:");
			System.out.println("Digite 0 para sair.");

			opcao = input.nextInt();

			if (opcao == 0) {
				break;
			}

			switch (opcao) {
			case 1:
				insereCliente(input);
				break;
			case 2:
				imprimeUmCliente(input);
				break;
			case 3:
				imprimeTodosCliente(input);
				break;
			case 4:
				atualizaCliente(input);
				break;
			case 5:
				deleta(input);
				break;
			}

		} while (opcao != 0);

		input.close();
	}

	public static void insereCliente(Scanner input) {

		System.out.println("Digite o nome do cliente: ");

		String nome = input.next();
		System.out.println("Digite a idade: ");
		int idade = input.nextInt();
		System.out.println("Digite o CPF: ");
		String cpf = input.next();
		System.out.println("Digite o e-mail: ");
		String email = input.next();
		System.out.println("Digite o número de telefone: ");
		String telefone = input.next();
		System.out.println("Digite o endereço: ");
		String endereco = input.next();

		Cliente cliente = new Cliente(nome, idade, cpf, email, telefone, endereco);
		listaDeClientes.put(cpf, cliente);

		imprimeCliente(cliente);
	}

	public static void atualizaCliente(Scanner input) {

		System.out.println("Digite o CPF: ");
		String cpf = input.next();
		Cliente cliente = listaDeClientes.get(cpf);

		System.out.println("Digite o nome do cliente: ");
		cliente.setNome(input.next());
		System.out.println("Digite a idade: ");
		cliente.setIdade(input.nextInt());
		System.out.println("Digite o e-mail: ");
		cliente.setEmail(input.next());
		System.out.println("Digite o número de telefone: ");
		cliente.setTelefone(input.next());
		System.out.println("Digite o endereço: ");
		cliente.setEndereço(input.next());

		listaDeClientes.put(cpf, cliente);

		imprimeCliente(cliente);
	}

	public static void imprimeUmCliente(Scanner input) {

		System.out.println("Digite um cpf para trazer um cliente.");
		String cpf = input.next();
		Cliente cliente = listaDeClientes.get(cpf);
		imprimeCliente(cliente);
	}

	public static void imprimeTodosCliente(Scanner input) {

		for (Cliente cliente : listaDeClientes.values()) {
			imprimeCliente(cliente);
		}
	}

	public static void deleta(Scanner input) {

		System.out.println("Digite o CPF: ");
		String cpf = input.next();

		listaDeClientes.remove(cpf);
	}

	private static void imprimeCliente(Cliente cliente) {

		System.out.printf("O nome do cliente é: %s. \n", cliente.getNome());
		System.out.printf("A idade: %d. \n", cliente.getIdade());
		System.out.printf("O CPF: %s \n", cliente.getCpf());
		System.out.printf("O e-mail: %s \n", cliente.getEmail());
		System.out.printf("O número de telefone: %d \n", cliente.getTelefone());
		System.out.printf("O endereço: %s \n\n", cliente.getEndereco());
	}

}
