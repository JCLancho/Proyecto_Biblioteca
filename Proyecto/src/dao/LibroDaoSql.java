package dao;

public abstract class LibroDaoSql {

	public static final String TABLA = "LIBRO";
	public static final String SELECT = "SELECT"
			+ " ISBN,"
			+ " TITULO,"
			+ " AUTOR,"
			+ " EDITORIAL,"
			+ " ASIGNATURA,"
			+ " ESTADO";
	
	public static final String DELETE = "DELETE";
	public static final String UPDATE = "UPDATE ";
	public static final String INSERT = "INSERT INTO ";
	
	public static final String FROM = " FROM " + TABLA;
	public static final String WHERE_ALL = " WHERE 1 = 1";
	public static final String WHERE_ISBN = " WHERE ISBN = UPPER(?)";
	public static final String VALUES = " (ISBN, TITULO, AUTOR, EDITORIAL, ASIGNATURA, ESTADO) VALUES (?,?,?,?,?,?)";
	public static final String SET = " SET TITULO = ?, AUTOR = ?, EDITORIAL = ?, ASIGNATURA = ?, ESTADO = ?";
	
	public static final String FIND = SELECT + FROM + WHERE_ISBN;
	public static final String FIND_ALL = SELECT + FROM + WHERE_ALL;
	
	public static final String DELETE_WHERE = DELETE + FROM + WHERE_ISBN;
	public static final String UPDATE_SET = UPDATE + TABLA + SET + WHERE_ISBN;
	public static final String INSERT_INTO = INSERT + TABLA + VALUES;
	
	
}
