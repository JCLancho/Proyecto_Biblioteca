package dao;

public abstract class AsignaturaDaoSql {

	public static final String TABLA = "ASIGNATURA";
	public static final String SELECT = "SELECT"
			+ " COD_ASIGNATURA,"
			+ " NOM_ASIGNATURA,"
			+ " ABREVIATURA";
	
	public static final String DELETE = "DELETE";
	public static final String UPDATE = "UPDATE ";
	public static final String INSERT = "INSERT INTO ";
	
	public static final String FROM = " FROM " + TABLA;
	public static final String WHERE_ALL = " WHERE 1 = 1";
	public static final String WHERE_COD_ASIGNATURA = " WHERE COD_ASIGNATURA = ?";
	public static final String VALUES = " (NOM_ASIGNATURA, ABREVIATURA) VALUES (?, UPPER(?))";
	public static final String SET = " SET NOM_ASIGNATURA = ?, ABREVIATURA = ?";
	
	public static final String FIND = SELECT + FROM + WHERE_COD_ASIGNATURA;
	public static final String FIND_ALL = SELECT + FROM + WHERE_ALL;
	
	public static final String DELETE_WHERE = DELETE + FROM + WHERE_COD_ASIGNATURA;
	public static final String UPDATE_SET = UPDATE + TABLA + SET + WHERE_COD_ASIGNATURA;
	public static final String INSERT_INTO = INSERT + TABLA + VALUES;
	
	
}
