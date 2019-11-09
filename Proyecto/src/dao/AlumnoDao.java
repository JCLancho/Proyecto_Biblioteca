package dao;

import java.util.List;

import javax.swing.tree.RowMapper;

import model.Alumno;

public interface AlumnoDao {

	Alumno find(String dni);
	
	List<Alumno> findAll(Alumno filtro);
	
	void add(String[] valores);
	
	void update(String[] valores, String dni);
	
	void delete(String dni);
		
	
}
