package Controller;

import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import dao.AsignaturaDao;
import dao.AsignaturaDaoImp;
import model.Asignatura;

public class AsignaturaController {

	private AsignaturaDao asignaturaDao;
	
	public AsignaturaController() {
		asignaturaDao = new AsignaturaDaoImp();
	}
	
	public Asignatura find(Long cod_asignatura) {
		return asignaturaDao.find(cod_asignatura);
		
	};
	
	public List<Asignatura> findAll(Asignatura filter) {
		return asignaturaDao.findAll(filter);
	}
	
	public void add(String[] valores) {
		asignaturaDao.add(valores);
	}
	
	public void update(String[] valores, String cod_asignatura) {
		asignaturaDao.update(valores, cod_asignatura);
	}
	
	public void delete(String cod_asignatura) throws MySQLIntegrityConstraintViolationException {
		asignaturaDao.delete(cod_asignatura);
	}
	
	
}
