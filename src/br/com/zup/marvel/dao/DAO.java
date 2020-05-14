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
	
	Connection conexao;
	public DAO() {
		this.conexao = new Factory().getConnection();
	}

	public void inserirCliente(Cliente cliente) {
		
		String sql = "insert into cliente "
				+ "values (?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setInt(2, cliente.getIdade());
			stmt.setString(3, cliente.getCpf());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getTelefone());
			stmt.setString(6, cliente.getEndereco());
			
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
			
			stmt.setString(1, cliente.getNome());
			stmt.setInt(2, cliente.getIdade());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getTelefone());
			stmt.setString(5, cliente.getEndereco());
			
			stmt.setString(6, cliente.getCpf());
			
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
			stmt.setString(1, cpf);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
 		
	}
}
