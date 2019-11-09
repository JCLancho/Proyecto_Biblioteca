package model;

public class Asignatura {

	private Long codAsignatura;
	private String nombreAsignatura;
	private String abreviatura;

	
	public Asignatura() {
		
	}
	
	public Long getCodAsignatura() {
		return codAsignatura;
	}
	
	public void setCodAsignatura(Long codAsignatura) {
		this.codAsignatura = codAsignatura;
	}
	
	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}
	
	public String getAbreviatura() {
		return abreviatura;
	}
	
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abreviatura == null) ? 0 : abreviatura.hashCode());
		result = prime * result + ((codAsignatura == null) ? 0 : codAsignatura.hashCode());
		result = prime * result + ((nombreAsignatura == null) ? 0 : nombreAsignatura.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		if (abreviatura == null) {
			if (other.abreviatura != null)
				return false;
		} else if (!abreviatura.equals(other.abreviatura))
			return false;
		if (codAsignatura == null) {
			if (other.codAsignatura != null)
				return false;
		} else if (!codAsignatura.equals(other.codAsignatura))
			return false;
		if (nombreAsignatura == null) {
			if (other.nombreAsignatura != null)
				return false;
		} else if (!nombreAsignatura.equals(other.nombreAsignatura))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.abreviatura;
	}
	
	
	
}
