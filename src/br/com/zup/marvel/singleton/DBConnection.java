package br.com.zup.marvel.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private DBConnection() {
		
	}

	static Connection connection = null;
	
    public static Connection getConnection() throws SQLException {
        try {
        	if (connection == null || connection.isClosed()) {
        		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/estrelas?user=root&password=root");
        		System.out.println(" Connection  - - - - - - - -  New DBConnection created");
        	}
            return connection;
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void close(Connection connection)
    {
        try {
            if (connection != null) {
                connection.close();
                connection=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
