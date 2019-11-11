package Controller;

import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import dao.AlumnoDao;
import dao.AlumnoDaoImp;
import model.Alumno;

/**
 * Controlador de Alumno
 * Capa intermedia entre la vida y el acceso a datos
 * @author jclan
 *
 */
public class AlumnoController {

	private AlumnoDao alumnoDao;
	
	public AlumnoController() {
		alumnoDao = new AlumnoDaoImp();
	}
	
	public Alumno find(String dni) {
		return alumnoDao.find(dni);
		
	};
	
	public List<Alumno> findAll(Alumno filtro) {
		return alumnoDao.findAll(filtro);
	}
	
	public void add(String[] valores) {
		alumnoDao.add(valores);
	}
	
	public void update(String[] valores, String dni) {
		alumnoDao.update(valores, dni);
	}
	
	public void delete(String dni) throws MySQLIntegrityConstraintViolationException {
		alumnoDao.delete(dni);
	}
	
	public void procedureInsertar(String[] valores) {
		alumnoDao.procedureInsertar(valores);
	}
	
	
}
