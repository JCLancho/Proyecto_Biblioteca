package service;

import java.util.List;

import dao.AlumnoDao;
import model.Alumno;

public interface AlumnoService {

	public Alumno find(String dni);
	
	public List<Alumno> findAll();
	
	public void add();
	
	public void update();
	
	public void delete(); 
	
	
	
}
