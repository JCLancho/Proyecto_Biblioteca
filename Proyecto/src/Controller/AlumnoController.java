package Controller;

import java.util.List;

import dao.AlumnoDao;
import dao.AlumnoDaoImp;
import model.Alumno;

public class AlumnoController {

	private AlumnoDao alumnoDao;
	
	public AlumnoController() {
		alumnoDao = new AlumnoDaoImp();
	}
	
	public Alumno find(String dni) {
		return null;
		
	};
	
	public List<Alumno> findAll() {
		return alumnoDao.findAll();
	}
	
	public void add() {
	}
	
	public void update() {
	}
	
	public void delete() {
	}
	
	
}
