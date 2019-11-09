package Controller;

import java.util.List;

import dao.LibroDao;
import dao.LibroDaoImp;
import model.Libro;

public class LibroController {

	private LibroDao libroDao;
	
	public LibroController() {
		libroDao = new LibroDaoImp();
	}
	
	public Libro find(String isbn) {
		return libroDao.find(isbn);
		
	};
	
	public List<Libro> findAll(Libro filtro) {
		return libroDao.findAll(filtro);
	}
	
	public void add(String[] valores) {
		libroDao.add(valores);
	}
	
	public void update(String[] valores, String isbn) {
		libroDao.update(valores, isbn);
	}
	
	public void delete(String isbn) {
		libroDao.delete(isbn);
	}
	
	
}
