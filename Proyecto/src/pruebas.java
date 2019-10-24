import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

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
		    PreparedStatement ps = con.prepareStatement("SELECT DNI FROM ALUMNO WHERE NOMBRE = ?");
		    ps.setString(1, "Carlos");
		    System.out.println(ps.toString());
		    ResultSet resultado = ps.executeQuery();
		    while(resultado.next()) {
		    	System.out.println(resultado.getString(1));
		    }
		    resultado.close();
		    ps.close();
		    con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	    
		
		
	}
	

	
	
	
}
