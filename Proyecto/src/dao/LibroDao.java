package dao;

import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import model.Libro;

public interface LibroDao {

	Libro find(String isbn);
	
	List<Libro> findAll(Libro filtro);
	
	void add(String[] valores);
	
	void update(String[] valores, String isbn);
	
	void delete(String isbn) throws MySQLIntegrityConstraintViolationException;
		
	
}
