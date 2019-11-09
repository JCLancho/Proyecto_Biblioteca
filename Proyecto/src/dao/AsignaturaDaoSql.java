package dao;

public abstract class AsignaturaDaoSql {

	public static String TABLA = "ASIGNATURA";
	public static String SELECT = "SELECT"
			+ " COD_ASIGNATURA,"
			+ " NOM_ASIGNATURA,"
			+ " ABREVIATURA";
	
	public static String DELETE = "DELETE";
	public static String UPDATE = "UPDATE ";
	public static String INSERT = "INSERT INTO ";
	
	public static String FROM = " FROM " + TABLA;
	public static String WHERE_ALL = " WHERE 1 = 1";
	public static String WHERE_COD_ASIGNATURA = " WHERE COD_ASIGNATURA = ?";
	public static String VALUES = " (NOM_ASIGNATURA, ABREVIATURA) VALUES (?, UPPER(?))";
	public static String SET = " SET NOM_ASIGNATURA = ?, ABREVIATURA = ?";
	
	public static String FIND = SELECT + FROM + WHERE_COD_ASIGNATURA;
	public static String FIND_ALL = SELECT + FROM + WHERE_ALL;
	
	public static String DELETE_WHERE = DELETE + FROM + WHERE_COD_ASIGNATURA;
	public static String UPDATE_SET = UPDATE + TABLA + SET + WHERE_COD_ASIGNATURA;
	public static String INSERT_INTO = INSERT + TABLA + VALUES;
	
	
}
