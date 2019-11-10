package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import Controller.AlumnoController;
import Controller.ConnectionController;
import Controller.EstadoController;
import Controller.LibroController;
import model.Alumno;
import model.Libro;
import model.Prestamo;

public class PrestamoDaoImp implements PrestamoDao{
	
	private ConnectionController cc;
	private String query;
	
	private AlumnoController alumnoController;
	private LibroController libroController;
	private EstadoController estadoController;
	
	public PrestamoDaoImp() {
		alumnoController = new AlumnoController();
		libroController = new LibroController();
		estadoController = new EstadoController();
	}

	@Override
	public Prestamo find(String[] keys) {
		cc = new ConnectionController();
		ResultSet rs = cc.find(PrestamoDaoSql.FIND, keys);
		if(rs != null) {
			try {
				Prestamo prestamo = new Prestamo();
				if(rs.next()) {
					Alumno alumno = alumnoController.find(rs.getString("ALUMNO"));
					prestamo.setAlumno(alumno);
					
					Libro libro = libroController.find(rs.getString("LIBRO"));
					prestamo.setLibro(libro);
					
					prestamo.setFechaPrestamo(rs.getDate("FECHAPRESTAMO"));
					prestamo.setFechaDevolucion(rs.getDate("FECHADEVOLUCION"));
					prestamo.setEstado(libro.getEstado());
				}
				cc.cerrar();
				rs.close();
				return prestamo;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		cc.cerrar();
		return null;
	}

	@Override
	public List<Prestamo> findAll(Prestamo filtro) {
		cc = new ConnectionController();
		String[] params = appendWhere(filtro);
		List<Prestamo> lista = new ArrayList<Prestamo>();
		ResultSet rs  = cc.findAll(query, params);
		if(rs != null) {
			try {
				while(rs.next()) {
					Prestamo prestamo = new Prestamo();
					Alumno alumno = alumnoController.find(rs.getString("ALUMNO"));
					prestamo.setAlumno(alumno);
					
					Libro libro = libroController.find(rs.getString("LIBRO"));
					prestamo.setLibro(libro);
					
					prestamo.setFechaPrestamo(rs.getDate("FECHAPRESTAMO"));
					prestamo.setFechaDevolucion(rs.getDate("FECHADEVOLUCION"));
					prestamo.setEstado(libro.getEstado());
					lista.add(prestamo);
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
		cc.add(PrestamoDaoSql.INSERT_INTO, valores);
		cc.cerrar();
	}

	@Override
	public void update(String[] valores, String[] keys) {
		cc = new ConnectionController();
		cc.update(PrestamoDaoSql.UPDATE_SET, valores, keys);
		cc.cerrar(); 
		
	}

	@Override
	public void delete(String[] keys) throws MySQLIntegrityConstraintViolationException {
		cc = new ConnectionController();
		cc.delete(PrestamoDaoSql.DELETE_WHERE, keys);
		cc.cerrar();
	}
	
	private String[] appendWhere(Prestamo filtro) {
		query = PrestamoDaoSql.FIND_ALL;
		StringBuffer q = new StringBuffer(query);
		ArrayList<String> listaParametros = new ArrayList<String>();
		if(filtro != null) {
			if(filtro.getAlumno() != null && filtro.getAlumno().getDni()!= null && !filtro.getAlumno().getDni().equals("")) {
				q.append(" AND UPPER(ALUMNO) LIKE CONCAT('%', UPPER(?), '%')");
				listaParametros.add(filtro.getAlumno().getDni());
			}
			if(filtro.getLibro() != null && filtro.getLibro().getIsbn() != null && !filtro.getLibro().getIsbn().equals("")) {
				q.append(" AND UPPER(LIBRO) LIKE CONCAT('%', UPPER(?), '%')");
				listaParametros.add(filtro.getLibro().getIsbn());
			}
			if(filtro.getFechaPrestamo() != null) {
				q.append(" AND FECHAPRESTAMO = ?)");
				listaParametros.add(filtro.getFechaPrestamo().toString());
			}
			if(filtro.getFechaDevolucion() != null) {
				q.append(" AND FECHADEVOLUCION = ?)");
				listaParametros.add(filtro.getFechaDevolucion().toString());
			}
			if(filtro.getAlumno() != null && filtro.getEstado() != null && !filtro.getEstado().getCodigo().equals("")) {
				q.append(" AND UPPER(ESTADO) LIKE CONCAT('%', UPPER(?), '%')");
				listaParametros.add(filtro.getEstado().getCodigo());
			}
			
		}
		this.query = q.toString();
		return listaParametros.toArray(new String[0]);
	}
	
	



}
