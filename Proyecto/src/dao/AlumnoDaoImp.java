package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import Controller.ConnectionController;
import model.Alumno;

/**
 * Clase de acceso a datos que implementa los metodos predefinidos
 * ligeras diferencias con sus clases hermanas en funcion la tabla que se ataque
 * @author Lancho
 *
 */
public class AlumnoDaoImp implements AlumnoDao{
	
	private ConnectionController cc;
	private String query;
	
	public AlumnoDaoImp() {
		
	}

	@Override
	public Alumno find(String dni) {
		cc = new ConnectionController();
		ResultSet rs = cc.find(AlumnoDaoSql.FIND, new String[] {dni});
		if(rs != null) {
			try {
				Alumno alumno = new Alumno();
				if(rs.next()) {
					alumno.setDni(rs.getString("DNI"));
					alumno.setNombre(rs.getString("NOMBRE"));
					alumno.setApellido1(rs.getString("APELLIDO1"));
					alumno.setApellido2(rs.getString("APELLIDO2"));
				}
				cc.cerrar();
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
	public List<Alumno> findAll(Alumno filtro) {
		cc = new ConnectionController();
		String[] params = appendWhere(filtro);
		List<Alumno> lista = new ArrayList<Alumno>();
		ResultSet rs  = cc.findAll(query, params);
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
	public void add(String[] valores) {
		cc = new ConnectionController();
		cc.add(AlumnoDaoSql.INSERT_INTO, valores);
		cc.cerrar();
	}

	@Override
	public void update(String[] valores, String dni) {
		cc = new ConnectionController();
		cc.update(AlumnoDaoSql.UPDATE_SET, valores, new String[] {dni});
		cc.cerrar(); 
		
	}

	@Override
	public void delete(String dni) throws MySQLIntegrityConstraintViolationException {
		cc = new ConnectionController();
		cc.delete(AlumnoDaoSql.DELETE_WHERE, new String[] {dni});
		cc.cerrar();
	}
	
	@Override
	public void procedureInsertar(String[] valores) {
		cc = new ConnectionController();
		cc.procedimiento(AlumnoDaoSql.PROCEDIMIENTO, valores);
		
	}
	
	private String[] appendWhere(Alumno filtro) {
		query = AlumnoDaoSql.FIND_ALL;
		StringBuffer q = new StringBuffer(query);
		ArrayList<String> listaParametros = new ArrayList<String>();
		if(filtro != null) {
			if(filtro.getDni() != null && !filtro.getDni().equals("")) {
				q.append(" AND UPPER(DNI) LIKE CONCAT('%', UPPER(?),'%')");
				listaParametros.add(filtro.getDni());
			}
			if(filtro.getNombre() != null && !filtro.getNombre().equals("")) {
				q.append(" AND UPPER(NOMBRE) LIKE CONCAT('%', UPPER(?),'%')");
				listaParametros.add(filtro.getNombre());
			}
			if(filtro.getApellido1() != null && !filtro.getApellido1().equals("")) {
				q.append(" AND UPPER(APELLIDO1) LIKE CONCAT('%', UPPER(?),'%')");
				listaParametros.add(filtro.getApellido1());
			}
			if(filtro.getApellido2() != null && !filtro.getApellido2().equals("")) {
				q.append(" AND UPPER(APELLIDO2) LIKE CONCAT('%', UPPER(?),'%')");
				listaParametros.add(filtro.getApellido2());
			}
		}
		this.query = q.toString();
		return listaParametros.toArray(new String[0]);
	}



}
