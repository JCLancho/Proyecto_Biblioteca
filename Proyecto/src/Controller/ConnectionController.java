package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectionController {

	private Connection con;
	private Statement st;
	private ResultSet resultado;
	
	public ConnectionController() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/PROYECTO","dm2", "dm2");
		    st = con.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Object find() {
		
		cerrar();
		return null;
	}
	
	public ResultSet findAll(String query){
		try {
			resultado = st.executeQuery(query);
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void add() {
	}
	
	public void update() {
	}
	
	public void delete() {
	}
	
	private void cerrar() {
		try {
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
