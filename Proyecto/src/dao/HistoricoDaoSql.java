package dao;

public abstract class HistoricoDaoSql {

	public static final String TABLA = "HISTORICO";
	public static final String SELECT = "SELECT"
			+ " ALUMNO,"
			+ " LIBRO,"
			+ " FECHAPRESTAMO,"
			+ " FECHADEVOLUCION,"
			+ " FECHADEVUSU,"
			+ " ESTADOINICIAL,"
			+ " ESTADOFINAL";
	
	public static final String DELETE = "DELETE";
	public static final String UPDATE = "UPDATE ";
	public static final String INSERT = "INSERT INTO ";
	
	public static final String FROM = " FROM " + TABLA;
	public static final String WHERE_ALL = " WHERE 1 = 1";
	public static final String VALUES = " (ALUMNO, LIBRO, FECHAPRESTAMO, FECHADEVOLUCION, FECHADEVUSU, ESTADOINICIAL, ESTADOFINAL) VALUES (?,?,?,?,NOW(),?,?)";
	
	public static final String FIND_ALL = SELECT + FROM + WHERE_ALL;
	
	public static final String INSERT_INTO = INSERT + TABLA + VALUES;
	
	
}
