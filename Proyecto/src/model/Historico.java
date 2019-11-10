package model;

import java.util.Date;

public class Historico {

	private Alumno alumno;
	private Libro libro;
	private Date fechaPrestamo;
	private Date fechaDevolucion;
	private Date fechaDevUsu;
	private Estado estadoInicial;
	private Estado estadoFinal;
	
	public Historico() {
		
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public Date getFechaDevUsu() {
		return fechaDevUsu;
	}

	public void setFechaDevUsu(Date fechaDevUsu) {
		this.fechaDevUsu = fechaDevUsu;
	}

	public Estado getEstadoInicial() {
		return estadoInicial;
	}

	public void setEstadoInicial(Estado estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

	public Estado getEstadoFinal() {
		return estadoFinal;
	}

	public void setEstadoFinal(Estado estadoFinal) {
		this.estadoFinal = estadoFinal;
	}
	
	
	
}
