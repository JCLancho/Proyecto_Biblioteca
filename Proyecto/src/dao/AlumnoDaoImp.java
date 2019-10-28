package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.ConnectionController;
import model.Alumno;

public class AlumnoDaoImp implements AlumnoDao{
	
	private ConnectionController cc;
	private String query;
	
	public AlumnoDaoImp() {
		
	}

	@Override
	public Alumno find(String dni) {
		cc = new ConnectionController();
		ResultSet rs = cc.find(AlumnoDaoSql.FIND, dni);
		if(rs != null) {
			try {
				Alumno alumno = new Alumno();
				if(rs.next()) {
					alumno.setDni(rs.getString("DNI"));
					alumno.setNombre(rs.getString("NOMBRE"));
					alumno.setApellido1(rs.getString("APELLIDO1"));
					alumno.setApellido2(rs.getString("APELLIDO2"));
				}
				rs.close();
				return alumno;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		cc.cerrar();
		return null;
	}

	@Override
	public List<Alumno> findAll(String[] params) {
		cc = new ConnectionController();
		appendWhere(params);
		List<Alumno> lista = new ArrayList<Alumno>();
		ResultSet rs  = cc.findAll(query, appendWhere(params));
		if(rs != null) {
			try {
				while(rs.next()) {
					Alumno alumno = new Alumno();
					alumno.setDni(rs.getString("DNI"));
					alumno.setNombre(rs.getString("NOMBRE"));
					alumno.setApellido1(rs.getString("APELLIDO1"));
					alumno.setApellido2(rs.getString("APELLIDO2"));
					lista.add(alumno);
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		cc.cerrar();
		return lista;
	}

	@Override
	public void add() {
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String dni) {
		cc = new ConnectionController();
		cc.delete(AlumnoDaoSql.DELETE_WHERE, dni);
		cc.cerrar();
	}
	
	private String[] appendWhere(String[] params) {
		query = AlumnoDaoSql.FIND_ALL;
		StringBuffer q = new StringBuffer(query);
		ArrayList<String> listaParametros = new ArrayList<String>();
		if(params.length > 0) {
			if(!params[0].equals("")) {
				q.append(" AND UPPER(DNI) = UPPER(?)");
				listaParametros.add(params[0]);
			}
			if(!params[1].equals("")) {
				q.append(" AND NOMBRE = UPPER(?)");
				listaParametros.add(params[1]);
			}
			if(!params[2].equals("")) {
				q.append(" AND APELLIDO1 = UPPER(?)");
				listaParametros.add(params[2]);
			}
			if(!params[3].equals("")) {
				q.append(" AND APELLIDO2 = UPPER(?)");
				listaParametros.add(params[3]);
			}
		}
		this.query = q.toString();
		return listaParametros.toArray(new String[0]);
	}
	
	



}
