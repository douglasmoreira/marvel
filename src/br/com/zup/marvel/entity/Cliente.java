package br.com.zup.marvel.entity;

public class Cliente {

	private String nome;
	private String idade;
	private String cpf;
	private String email;
	private String telefone;
	private String endereço;
	
	public Cliente(String nome, String idade, String cpf, String email, String telefone, String endereço) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.endereço = endereço;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereço() {
		return endereço;
	}
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	
}
