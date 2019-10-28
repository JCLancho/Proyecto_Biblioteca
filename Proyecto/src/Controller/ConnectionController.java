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
			this.con = DriverManager.getConnection("jdbc:mysql://localhost/PROYECTO","dm2", "dm2");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ResultSet find(String query, String[] keys) {
		try {
			this.ps = this.con.prepareStatement(query);
			for(int i = 0; i < keys.length; i++) {
				this.ps.setString(i+1, keys[i]);
			}
			return this.ps.executeQuery();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet findAll(String query, String[] params){
		try {
			this.ps = this.con.prepareStatement(query);
			for(int i = 0; i < params.length; i++) {
				this.ps.setString(i+1, params[i]);
			}
			return this.ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void add(String query, String[] valores) {
		try {
			this.ps = this.con.prepareStatement(query);
			for(int i = 0; i < valores.length; i++) {
				this.ps.setString(i+1, valores[i]);
			}
			this.ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(String query, String[] valores, String[] keys) {
		try {
			int contador = 1;
			this.ps = this.con.prepareStatement(query);
			for(int i = 0; i < valores.length; i++) {
				this.ps.setString(contador, valores[i]);
				contador++;
			}
			for(int i = 0; i < keys.length; i++) {
				this.ps.setString(contador, keys[i]);
				contador++;
			}
			this.ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String query, String[] keys) {
		try {
			this.ps = this.con.prepareStatement(query);
			for(int i = 0; i < keys.length; i++) {
				this.ps.setString(i+1, keys[i]);
			}
			this.ps.executeUpdate();
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
