package dao;

public abstract class AlumnoDaoSql {

	public static String TABLA = "ALUMNO";
	public static String SELECT = "SELECT"
			+ " DNI,"
			+ "NOMBRE,"
			+ "APELLIDO1,"
			+ "APELLIDO2";
	
	public static String FROM = " FROM " + AlumnoDaoSql.TABLA;
	public static String WHERE_ALL = " WHERE 1 = 1";
	
	public static String FIND = AlumnoDaoSql.SELECT + AlumnoDaoSql.FROM + AlumnoDaoSql.WHERE_ALL; 
	
}
