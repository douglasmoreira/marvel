package br.com.zup.marvel.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.zup.marvel.entity.Cliente;
import br.com.zup.marvel.singleton.DBConnection;

public class ClienteDAO {

    public List<Cliente> findAll() {
        List<Cliente> clienteList = new ArrayList<Cliente>();
        Connection c = null;
        String sql = "SELECT * FROM cliente";
        try {
            c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clienteList.add(processRow(rs));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(c);
        }
        return clienteList;
    }

    public Cliente findByCpf(String cpf) {
        String sql = "SELECT * FROM cliente WHERE cpf = ?";
        Cliente cliente = null;
        Connection c = null;
        try {
            c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = processRow(rs);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(c);
        }
        return cliente;
    }

    public Cliente save(Cliente cliente) {
        return cliente.getCpf() != null ? update(cliente) : insert(cliente);
    }

    public Cliente insert(Cliente cliente) {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DBConnection.getConnection();
            ps = c.prepareStatement(
                    "INSERT INTO cliente (nome, idade, cpf, email, telefone, endereco) VALUES (?, ?, ?, ?, ?, ?)",
                    new String[] { "cpf" });

            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getIdade());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getTelefone());
            ps.setString(6, cliente.getEndereco());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
            cliente.setCpf(cliente.getCpf());
            }
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(c);
        }
        return cliente;
    }

    public Cliente update(Cliente cliente) {
        Connection c = null;
        try {
            c = DBConnection.getConnection();
            PreparedStatement ps = c
                    .prepareStatement("UPDATE cliente "
                    		+ "SET nome=?, "
                    		+ "idade=?, "
                    		+ "email=?, "
                    		+ "telefone=?, "
                    		+ "endereco=?  "
                    		+ "WHERE cpf=?");
            
            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getIdade());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getTelefone());
            ps.setString(5, cliente.getEndereco());
            ps.setString(6, cliente.getCpf());
            
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("clienteDAO update exception");
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(c);
        }
        return cliente;
    }

    public boolean remove(String cpf) {
        Connection c = null;
        try {
            c = DBConnection.getConnection();
            PreparedStatement ps = c
                    .prepareStatement("DELETE FROM cliente WHERE cpf=?");
            ps.setString(1, cpf);
            boolean count = ps.execute();
            ps.close();
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(c);
        }
    }

    protected Cliente processRow(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente(
        		rs.getString("nome"), 
        		rs.getInt("idade"), 
        		rs.getString("cpf"), 
        		rs.getString("email"), 
        		rs.getString("telefone"), 
        		rs.getString("endereco"));

        return cliente;

    }
}
