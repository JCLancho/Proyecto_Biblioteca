
public class Estado {

	private String estado;
	
	public Estado() {
		
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(this.getClass().getName()).append("Object {");
		result.append(" [Estado: ").append(this.getEstado()).append("]");
		result.append("}");
		return result.toString();
	}
	
}
