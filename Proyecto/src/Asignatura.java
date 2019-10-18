
public class Asignatura {

	private String nombreAsignatura;

	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(this.getClass().getName()).append("Object {");
		result.append(" [Nombre: ").append(this.getNombreAsignatura()).append("]");
		result.append("}");
		return result.toString();
	}
	
	
	
}
