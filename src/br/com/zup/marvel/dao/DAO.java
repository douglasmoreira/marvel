package br.com.zup.marvel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import br.com.zup.marvel.entity.Cliente;
import br.com.zup.marvel.factory.Factory;

public class DAO {
	
	private static final int POSICAO_NOME_CREATE = 1;
	private static final int POSICAO_IDADE_CREATE = 2;
	private static final int POSICAO_CPF_CREATE = 3;
	private static final int POSICAO_EMAIL_CREATE = 4;
	private static final int POSICAO_TELEFONE_CREATE = 5;
	private static final int POSICAO_ENDERECO_CREATE = 6;
	
	private static final int POSICAO_NOME_UPDATE = 1;
	private static final int POSICAO_IDADE_UPDATE = 2;
	private static final int POSICAO_EMAIL_UPDATE = 3;
	private static final int POSICAO_TELEFONE_UPDATE = 4;
	private static final int POSICAO_ENDERECO_UPDATE = 5;
	private static final int POSICAO_CPF_UPDATE = 6;

	private static final int POSICAO_CPF_DELETE = 1;
	
	Connection conexao;
	
	public DAO() {
		this.conexao = new Factory().getConnection();
	}

	public void inserirCliente(Cliente cliente) {
		
		String sql = "insert into cliente "
				+ "values (?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(POSICAO_NOME_CREATE, cliente.getNome());
			stmt.setInt(POSICAO_IDADE_CREATE, cliente.getIdade());
			stmt.setString(POSICAO_CPF_CREATE, cliente.getCpf());
			stmt.setString(POSICAO_EMAIL_CREATE, cliente.getEmail());
			stmt.setString(POSICAO_TELEFONE_CREATE, cliente.getTelefone());
			stmt.setString(POSICAO_ENDERECO_CREATE, cliente.getEndereco());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizaCliente(String cpf, Cliente cliente) {
		
		String sql = "update cliente "
				+ "set nome = ?, "
				+ "idade = ?, "
				+ "email = ?, "
				+ "telefone = ?, "
				+ "endereco = ? "
				+ "where cpf = ? ";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(POSICAO_NOME_UPDATE, cliente.getNome());
			stmt.setInt(POSICAO_IDADE_UPDATE, cliente.getIdade());
			stmt.setString(POSICAO_EMAIL_UPDATE, cliente.getEmail());
			stmt.setString(POSICAO_TELEFONE_UPDATE, cliente.getTelefone());
			stmt.setString(POSICAO_ENDERECO_UPDATE, cliente.getEndereco());
			
			stmt.setString(POSICAO_CPF_UPDATE, cliente.getCpf());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Map<String, Cliente> recuperaListaDeClientes() {
		
		Map<String, Cliente> clienteList = new HashMap<String, Cliente>();
		String sql = "select * from cliente";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				String nome = rs.getString("nome");
				int idade = rs.getInt("idade");
				String cpf = rs.getString("cpf");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				String endereco = rs.getString("endereco");
				
				Cliente cliente = new Cliente(nome, idade, cpf, email, telefone, endereco);
				
				clienteList.put(cpf, cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clienteList;
	}
	
public Cliente recuperaClientes(String cpfRequest) {
		
	Cliente cliente = null;
		String sql = "select * from cliente "
				+ "where cpf = ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cpfRequest);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				String nome = rs.getString("nome");
				int idade = rs.getInt("idade");
				String cpf = rs.getString("cpf");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				String endereco = rs.getString("endereco");
				
				cliente = new Cliente(nome, idade, cpf, email, telefone, endereco);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	public void deletaCliente(String cpf) {
		
		String sql = "delete from cliente "
				+ "where cpf = ? ";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(POSICAO_CPF_DELETE, cpf);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
 		
	}
}
