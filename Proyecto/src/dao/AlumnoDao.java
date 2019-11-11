package dao;

import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import model.Alumno;

/**
 * Interfaz de Alumno
 * Con los metodos que usara para objetener información de la bbdd
 * @author Lancho
 *
 */
public interface AlumnoDao {

	Alumno find(String dni);
	
	List<Alumno> findAll(Alumno filtro);
	
	void add(String[] valores);
	
	void update(String[] valores, String dni);
	
	void delete(String dni) throws MySQLIntegrityConstraintViolationException;
	
	void procedureInsertar(String [] valores);
		
	
}
