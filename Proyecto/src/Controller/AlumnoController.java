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
		return alumnoDao.find(dni);
		
	};
	
	public List<Alumno> findAll(String[] params) {
		return alumnoDao.findAll(params);
	}
	
	public void add() {
	}
	
	public void update() {
	}
	
	public void delete(String dni) {
		alumnoDao.delete(dni);
	}
	
	
}
