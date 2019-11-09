package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.AsignaturaController;
import Controller.ConnectionController;
import Controller.EstadoController;
import model.Asignatura;
import model.Estado;
import model.Libro;

public class LibroDaoImp implements LibroDao{
	
	private ConnectionController cc;
	private String query;
	private AsignaturaController asignaturaController;
	private EstadoController estadoController;
	
	public LibroDaoImp() {
		asignaturaController = new AsignaturaController();
		estadoController = new EstadoController();
	}

	@Override
	public Libro find(String isbn) {
		cc = new ConnectionController();
		ResultSet rs = cc.find(LibroDaoSql.FIND, new String[] {isbn});
		if(rs != null) {
			try {
				Libro libro = new Libro();
				if(rs.next()) {
					libro.setIsbn(rs.getString("ISBN"));
					libro.setTitulo(rs.getString("TITULO"));
					libro.setAutor(rs.getString("AUTOR"));
					libro.setEditorial(rs.getString("EDITORIAL"));
					
					Asignatura asignatura = asignaturaController.find(rs.getLong("COD_ASIGNATURA"));
					libro.setAsignatura(asignatura);
					
					Estado estado = estadoController.find(rs.getString("COD_ESTADO"));
					libro.setEstado(estado);
				}
				rs.close();
				return libro;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		cc.cerrar();
		return null;
	}

	@Override
	public List<Libro> findAll(Libro filtro) {
		cc = new ConnectionController();
		String[] params = appendWhere(filtro);
		List<Libro> lista = new ArrayList<Libro>();
		ResultSet rs  = cc.findAll(query, params);
		if(rs != null) {
			try {
				while(rs.next()) {
					Libro libro = new Libro();
					libro.setIsbn(rs.getString("ISBN"));
					libro.setTitulo(rs.getString("TITULO"));
					libro.setAutor(rs.getString("AUTOR"));
					libro.setEditorial(rs.getString("EDITORIAL"));
					
					Asignatura asignatura = asignaturaController.find(rs.getLong("ASIGNATURA"));
					libro.setAsignatura(asignatura);
					
					Estado estado = estadoController.find(rs.getString("ESTADO"));
					libro.setEstado(estado);
					lista.add(libro);
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
		cc.add(LibroDaoSql.INSERT_INTO, valores);
		cc.cerrar();
	}

	@Override
	public void update(String[] valores, String isbn) {
		cc = new ConnectionController();
		cc.update(LibroDaoSql.UPDATE_SET, valores, new String[] {isbn});
		cc.cerrar(); 
		
	}

	@Override
	public void delete(String isbn) {
		cc = new ConnectionController();
		cc.delete(LibroDaoSql.DELETE_WHERE, new String[] {isbn});
		cc.cerrar();
	}
	
	private String[] appendWhere(Libro filtro) {
		this.query = LibroDaoSql.FIND_ALL;
		StringBuffer q = new StringBuffer(query);
		ArrayList<String> listaParametros = new ArrayList<String>();
		if(filtro != null) {
			if(filtro.getIsbn() != null && !filtro.getIsbn().equals("")) {
				q.append(" AND UPPER(ISBN) LIKE CONCAT('%', UPPER(?),'%')");
				listaParametros.add(filtro.getIsbn());
			}
			if(filtro.getTitulo() != null && !filtro.getTitulo().equals("")) {
				q.append(" AND UPPER(TITULO) LIKE CONCAT('%', UPPER(?),'%')");
				listaParametros.add(filtro.getTitulo());
			}
			if(filtro.getAutor()!= null && !filtro.getAutor().equals("")) {
				q.append(" AND UPPER(AUTOR) LIKE CONCAT('%', UPPER(?),'%')");
				listaParametros.add(filtro.getAutor());
			}
			if(filtro.getEditorial() != null && !filtro.getEditorial().equals("")) {
				q.append(" AND UPPER(EDITORIAL) LIKE CONCAT('%', UPPER(?),'%')");
				listaParametros.add(filtro.getEditorial());
			}
			if(filtro.getAsignatura() != null && filtro.getAsignatura().getCodAsignatura() != null && !filtro.getAsignatura().getCodAsignatura().equals("")) {
				q.append(" AND ASIGNATURA = ?");
				listaParametros.add(filtro.getAsignatura().getCodAsignatura().toString());
			}
			if(filtro.getEstado() != null && filtro.getEstado().getCodigo() != null && !filtro.getEstado().getCodigo().equals("")) {
				q.append(" AND UPPER(ESTADO) = UPPER(?)");
				listaParametros.add(filtro.getEstado().getCodigo());
			}
		}
		this.query = q.toString();
		return listaParametros.toArray(new String[0]);
	}
	
	



}
