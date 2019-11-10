package dao;

import java.sql.Date;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import model.Prestamo;

public interface PrestamoDao {

	Prestamo find(String[] keys);
	
	List<Prestamo> findAll(Prestamo filtro);
	
	void add(String[] valores);
	
	void update(String[] valores, String[] keys);
	
	void delete(String[] keys) throws MySQLIntegrityConstraintViolationException;
		
	
}
