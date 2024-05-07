package model_package;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/instituto";
		String usuario = "root";
		String password = "root";
		Connection connection = null;

		if (connection == null) {
			try {
		
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					System.out.print("Error al conectar a las base: " + e.getMessage());

				}
				connection = DriverManager.getConnection(url, usuario, password);
				boolean valida = connection.isValid(50000);//para ver si se realiza la conexion en un tiempo dado
				System.out.println(valida ? " Connection realizada " : "Connection fallida");
			} catch (java.sql.SQLException e) {
				System.out.println("Error sql: " + e.getErrorCode());
			}
		}
		return connection;
	}
}
