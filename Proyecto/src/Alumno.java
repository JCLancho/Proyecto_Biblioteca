public class Alumno {

	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	
	public Alumno() {
		
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	public String getNombreCompleto() {
		return this.nombre + " " + this.apellido1 + " " + this.apellido2;
	}
	
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(this.getClass().getName()).append("Object {");
		result.append(" [DNI: ").append(this.getDni()).append("]");
		result.append(" [Nombre: ").append(this.getNombre()).append("]");
		result.append(" [Apellido 1: ").append(this.getApellido1()).append("]");
		result.append(" [Apellido 2: ").append(this.getApellido2()).append("]");
		result.append("}");
		return result.toString();
	}
	
	
	
}
