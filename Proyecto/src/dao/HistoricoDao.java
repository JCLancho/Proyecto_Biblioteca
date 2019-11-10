package dao;

import java.util.List;

import model.Historico;

public interface HistoricoDao {
	
	List<Historico> findAll(Historico filtro);
	
	void add(String[] valores);
	
}
