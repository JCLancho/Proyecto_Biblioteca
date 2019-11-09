package dao;

import java.util.List;

import model.Estado;

public interface EstadoDao {

	Estado find(String cod_estado);
	
	List<Estado> findAll(Estado filtro);
	
	void add(String[] valores);
	
	void update(String[] valores, String cod_estado);
	
	void delete(String cod_estado);
		
	
}
