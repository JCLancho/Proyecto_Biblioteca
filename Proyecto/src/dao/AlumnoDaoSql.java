package dao;

public abstract class AlumnoDaoSql {

	public static final String TABLA = "ALUMNO";
	public static final String SELECT = "SELECT"
			+ " DNI,"
			+ " NOMBRE,"
			+ " APELLIDO1,"
			+ " APELLIDO2";
	
	public static final String DELETE = "DELETE";
	public static final String UPDATE = "UPDATE ";
	public static final String INSERT = "INSERT INTO ";
	
	public static final String FROM = " FROM " + TABLA;
	public static final String WHERE_ALL = " WHERE 1 = 1";
	public static final String WHERE_DNI = " WHERE DNI = UPPER(?)";
	public static final String VALUES = " (DNI, NOMBRE, APELLIDO1, APELLIDO2) VALUES (?,?,?,?)";
	public static final String SET = " SET NOMBRE = ?, APELLIDO1 = ?, APELLIDO2 = ?";
	
	public static final String FIND = SELECT + FROM + WHERE_DNI;
	public static final String FIND_ALL = SELECT + FROM + WHERE_ALL;
	
	public static final String DELETE_WHERE = DELETE + FROM + WHERE_DNI;
	public static final String UPDATE_SET = UPDATE + TABLA + SET + WHERE_DNI;
	public static final String INSERT_INTO = INSERT + TABLA + VALUES;
	
	public static final String PROCEDIMIENTO = "CALL INSERTAR_ALUMNO(?,?,?,?)";
	
	
}
