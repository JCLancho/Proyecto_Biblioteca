package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;


public class ConnectionController {

	private Connection con;
	private PreparedStatement ps;
	
	public ConnectionController() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/PROYECTO","dm2", "dm2");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ResultSet find(String query, String dni) {
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, dni);
			return ps.executeQuery();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet findAll(String query, String[] params){
		try {
			ps = con.prepareStatement(query);
			for(int i = 0; i < params.length; i++) {
				ps.setString(i+1, params[i]);
			}
			return ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void add() {
		
	}
	
	public void update() {
	}
	
	public void delete(String query, String dni) {
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, dni);
			ps.executeUpdate();
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cerrar() {
		try {
			this.ps.close();
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
