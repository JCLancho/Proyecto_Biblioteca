package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.ConnectionController;
import model.Alumno;

public class AlumnoDaoImp implements AlumnoDao{
	
	private ConnectionController cc;
	
	public AlumnoDaoImp() {
		cc = new ConnectionController();
	}

	@Override
	public Alumno find(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumno> findAll() {
		List<Alumno> lista = new ArrayList<Alumno>();
		ResultSet rs  = cc.findAll(AlumnoDaoSql.FIND);
		if(rs != null) {
			try {
				while(rs.next()) {
					Alumno a = new Alumno();
					a.setDni(rs.getString("DNI"));
					a.setNombre(rs.getString("NOMBRE"));
					a.setApellido1(rs.getString("APELLIDO1"));
					a.setApellido2(rs.getString("APELLIDO2"));
					lista.add(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
	



}
