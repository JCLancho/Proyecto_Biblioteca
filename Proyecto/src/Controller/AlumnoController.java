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
	
	public void add(String[] valores) {
		alumnoDao.add(valores);
	}
	
	public void update(String[] valores, String dni) {
		alumnoDao.update(valores, dni);
	}
	
	public void delete(String dni) {
		alumnoDao.delete(dni);
	}
	
	
}
