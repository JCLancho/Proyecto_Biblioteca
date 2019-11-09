package dao;

public abstract class LibroDaoSql {

	public static String TABLA = "LIBRO";
	public static String SELECT = "SELECT"
			+ " ISBN,"
			+ " TITULO,"
			+ " AUTOR,"
			+ " EDITORIAL,"
			+ " ASIGNATURA,"
			+ " ESTADO";
	
	public static String DELETE = "DELETE";
	public static String UPDATE = "UPDATE ";
	public static String INSERT = "INSERT INTO ";
	
	public static String FROM = " FROM " + TABLA;
	public static String WHERE_ALL = " WHERE 1 = 1";
	public static String WHERE_ISBN = " WHERE ISBN = UPPER(?)";
	public static String VALUES = " (ISBN, TITULO, AUTOR, EDITORIAL, ASIGNATURA, ESTADO) VALUES (?,?,?,?,?,?)";
	public static String SET = " SET TITULO = ?, AUTOR = ?, EDITORIAL = ?, ASIGNATURA = ?, ESTADO = ?";
	
	public static String FIND = SELECT + FROM + WHERE_ISBN;
	public static String FIND_ALL = SELECT + FROM + WHERE_ALL;
	
	public static String DELETE_WHERE = DELETE + FROM + WHERE_ISBN;
	public static String UPDATE_SET = UPDATE + TABLA + SET + WHERE_ISBN;
	public static String INSERT_INTO = INSERT + TABLA + VALUES;
	
	
}
