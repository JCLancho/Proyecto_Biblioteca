package dao;

import java.util.List;

import javax.swing.tree.RowMapper;

import model.Alumno;

public interface AlumnoDao {

	public Alumno find(String dni);
	
	public List<Alumno> findAll(String[] params);
	
	public void add();
	
	public void update();
	
	public void delete(String dni);
		
	
}
