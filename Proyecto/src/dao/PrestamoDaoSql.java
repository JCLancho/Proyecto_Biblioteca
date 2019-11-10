package dao;

public abstract class PrestamoDaoSql {

	public static final String TABLA = "PRESTAMO";
	public static final String SELECT = "SELECT"
			+ " ALUMNO,"
			+ " LIBRO,"
			+ " FECHAPRESTAMO,"
			+ " FECHADEVOLUCION,"
			+ " ESTADO";
	
	public static final String DELETE = "DELETE";
	public static final String UPDATE = "UPDATE ";
	public static final String INSERT = "INSERT INTO ";
	
	public static final String FROM = " FROM " + TABLA;
	public static final String WHERE_ALL = " WHERE 1 = 1";
	public static final String WHERE_KEY = " WHERE ALUMNO = UPPER(?) AND LIBRO = UPPER(?) AND FECHAPRESTAMO = STR_TO_DATE(?,'%Y-%m-%d')";
	public static final String VALUES = " (ALUMNO, LIBRO, FECHAPRESTAMO, FECHADEVOLUCION, ESTADO) VALUES (?,?,NOW(),ADDDATE(NOW(),INTERVAL 15 DAY),?)";
	public static final String SET = " SET FECHADEVOLUCION = ADDDATE(NOW(),INTERVAL 15 DAY)";
	
	public static final String FIND = SELECT + FROM + WHERE_KEY;
	public static final String FIND_ALL = SELECT + FROM + WHERE_ALL;
	
	public static final String DELETE_WHERE = DELETE + FROM + WHERE_KEY;
	public static final String UPDATE_SET = UPDATE + TABLA + SET + WHERE_KEY;
	public static final String INSERT_INTO = INSERT + TABLA + VALUES;
	
}
