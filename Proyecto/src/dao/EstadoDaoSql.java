package dao;

public abstract class EstadoDaoSql {

	public static String TABLA = "ESTADO";
	public static String SELECT = "SELECT"
			+ " COD_ESTADO,"
			+ " DESCRIPCION";
	
	public static String DELETE = "DELETE";
	public static String UPDATE = "UPDATE ";
	public static String INSERT = "INSERT INTO ";
	
	public static String FROM = " FROM " + TABLA;
	public static String WHERE_ALL = " WHERE 1 = 1";
	public static String WHERE_COD_ESTADO = " WHERE COD_ESTADO = UPPER(?)";
	public static String VALUES = " (COD_ESTADO, DESCRIPCION) VALUES (?,?)";
	public static String SET = " SET DESCRIPCION = ?";
	
	public static String FIND = SELECT + FROM + WHERE_COD_ESTADO;
	public static String FIND_ALL = SELECT + FROM + WHERE_ALL;
	
	public static String DELETE_WHERE = DELETE + FROM + WHERE_COD_ESTADO;
	public static String UPDATE_SET = UPDATE + TABLA + SET + WHERE_COD_ESTADO;
	public static String INSERT_INTO = INSERT + TABLA + VALUES;
	
	
}
