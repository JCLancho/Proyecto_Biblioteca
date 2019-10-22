package model;
public class Libro {

	private String isbn;
	private String titulo;
	private String autor;
	private String editorial;
	private Asignatura asignatura;
	private Estado estado;
	
	public Libro() {
		
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(this.getClass().getName()).append("Object {");
		result.append(" [ISBN: ").append(this.getIsbn()).append("]");
		result.append(" [Titulo: ").append(this.getTitulo()).append("]");
		result.append(" [Autor: ").append(this.getAutor()).append("]");
		result.append(" [Editorial: ").append(this.getEditorial()).append("]");
		result.append(" [Asignatura: ").append(this.getAsignatura().toString()).append("]");
		result.append(" [Estado: ").append(this.getEstado().toString()).append("]");
		result.append("}");
		return result.toString();
	}
	
}
