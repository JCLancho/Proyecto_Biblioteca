package Controller;

import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import dao.PrestamoDao;
import dao.PrestamoDaoImp;
import model.Prestamo;

public class PrestamoController {

	private PrestamoDao prestamoDao;
	
	public PrestamoController() {
		prestamoDao = new PrestamoDaoImp();
	}
	
	public Prestamo find(String[] keys) {
		return prestamoDao.find(keys);
		
	};
	
	public List<Prestamo> findAll(Prestamo filtro) {
		return prestamoDao.findAll(filtro);
	}
	
	public void add(String[] valores) {
		prestamoDao.add(valores);
	}
	
	public void update(String[] valores, String[] keys) {
		prestamoDao.update(valores, keys);
	}
	
	public void delete(String[] keys) throws MySQLIntegrityConstraintViolationException {
		prestamoDao.delete(keys);
	}
	
	
}
