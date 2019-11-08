package dao;

public abstract class LibroDaoSql {

	public static String TABLA = "ALUMNO";
	public static String SELECT = "SELECT"
			+ " DNI,"
			+ " NOMBRE,"
			+ " APELLIDO1,"
			+ " APELLIDO2";
	
	public static String DELETE = "DELETE";
	public static String UPDATE = "UPDATE ";
	public static String INSERT = "INSERT INTO ";
	
	public static String FROM = " FROM " + TABLA;
	public static String WHERE_ALL = " WHERE 1 = 1";
	public static String WHERE_DNI = " WHERE DNI = UPPER(?)";
	public static String VALUES = " (DNI, NOMBRE, APELLIDO1, APELLIDO2) VALUES (?,?,?,?)";
	public static String SET = " SET NOMBRE = ?, APELLIDO1 = ?, APELLIDO2 = ?";
	
	public static String FIND = SELECT + FROM + WHERE_DNI;
	public static String FIND_ALL = SELECT + FROM + WHERE_ALL;
	
	public static String DELETE_WHERE = DELETE + FROM + WHERE_DNI;
	public static String UPDATE_SET = UPDATE + TABLA + SET + WHERE_DNI;
	public static String INSERT_INTO = INSERT + TABLA + VALUES;
	
	
}
