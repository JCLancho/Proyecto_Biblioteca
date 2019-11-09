package Controller;

import java.util.List;

import dao.EstadoDao;
import dao.EstadoDaoImp;
import model.Estado;

public class EstadoController {

	private EstadoDao estadoDao;
	
	public EstadoController() {
		estadoDao = new EstadoDaoImp();
	}
	
	public Estado find(String cod_estado) {
		return estadoDao.find(cod_estado);
		
	};
	
	public List<Estado> findAll(Estado filtro) {
		return estadoDao.findAll(filtro);
	}
	
	public void add(String[] valores) {
		estadoDao.add(valores);
	}
	
	public void update(String[] valores, String cod_estado) {
		estadoDao.update(valores, cod_estado);
	}
	
	public void delete(String cod_estado) {
		estadoDao.delete(cod_estado);
	}
	
	
}
