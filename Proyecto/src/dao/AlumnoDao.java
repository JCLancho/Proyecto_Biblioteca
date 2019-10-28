package dao;

import java.util.List;

import javax.swing.tree.RowMapper;

import model.Alumno;

public interface AlumnoDao {

	Alumno find(String dni);
	
	List<Alumno> findAll(String[] params);
	
	void add();
	
	void update();
	
	void delete(String dni);
		
	
}
