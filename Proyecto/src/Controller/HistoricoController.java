package Controller;

import java.util.List;

import dao.HistoricoDao;
import dao.HistoricoDaoImp;
import model.Historico;

public class HistoricoController {

	private HistoricoDao historicoDao;
	
	public HistoricoController() {
		historicoDao = new HistoricoDaoImp();
	}
	
	
	public List<Historico> findAll(Historico filtro) {
		return historicoDao.findAll(filtro);
	}
	
	public void add(String[] valores) {
		historicoDao.add(valores);
	}
	
	
	
}
