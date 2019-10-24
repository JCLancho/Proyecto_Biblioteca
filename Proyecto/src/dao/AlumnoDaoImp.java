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
		// TODO Auto-generated method stub
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
					Alumno a = new Alumno();
					a.setDni(rs.getString("DNI"));
					a.setNombre(rs.getString("NOMBRE"));
					a.setApellido1(rs.getString("APELLIDO1"));
					a.setApellido2(rs.getString("APELLIDO2"));
					lista.add(a);
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
