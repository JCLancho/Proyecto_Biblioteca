import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class pruebas {

	
	public static void main(String[] args){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/PROYECTO","dm2", "dm2");
		    Statement st = con.createStatement();
		    String consulta = "SELECT * FROM ALUMNO";
		    ResultSet resultado = st.executeQuery(consulta);
		    while(resultado.next()) {
		    	System.out.println(resultado.getString("DNI"));
		    }
		    resultado.close();
		    st.close();
		    con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	    
		
		
	}
	

	
	
	
}
