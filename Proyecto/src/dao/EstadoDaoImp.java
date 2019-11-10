package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import Controller.ConnectionController;
import model.Estado;

public class EstadoDaoImp implements EstadoDao{
	
	private ConnectionController cc;
	private String query;
	
	public EstadoDaoImp() {
		
	}

	@Override
	public Estado find(String cod_estado) {
		cc = new ConnectionController();
		ResultSet rs = cc.find(EstadoDaoSql.FIND, new String[] {cod_estado});
		if(rs != null) {
			try {
				Estado estado = new Estado();
				if(rs.next()) {
					estado.setCodigo(rs.getString("COD_ESTADO"));
					estado.setDescripcion(rs.getString("DESCRIPCION"));
				}
				cc.cerrar();
				rs.close();
				return estado;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		cc.cerrar();
		return null;
	}

	@Override
	public List<Estado> findAll(Estado filtro) {
		cc = new ConnectionController();
		String[] params = appendWhere(filtro);
		List<Estado> lista = new ArrayList<Estado>();
		ResultSet rs  = cc.findAll(query, params);
		if(rs != null) {
			try {
				while(rs.next()) {
					Estado estado = new Estado();
					estado.setCodigo(rs.getString("COD_ESTADO"));
					estado.setDescripcion(rs.getString("DESCRIPCION"));
					lista.add(estado);
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		cc.cerrar();
		return lista;
	}

	@Override
	public void add(String[] valores) {
		cc = new ConnectionController();
		cc.add(EstadoDaoSql.INSERT_INTO, valores);
		cc.cerrar();
	}

	@Override
	public void update(String[] valores, String cod_estado) {
		cc = new ConnectionController();
		cc.update(EstadoDaoSql.UPDATE_SET, valores, new String[] {cod_estado});
		cc.cerrar(); 
		
	}

	@Override
	public void delete(String cod_estado) throws MySQLIntegrityConstraintViolationException {
		cc = new ConnectionController();
		cc.delete(EstadoDaoSql.DELETE_WHERE, new String[] {cod_estado});
		cc.cerrar();
	}
	
	private String[] appendWhere(Estado filtro) {
		query = EstadoDaoSql.FIND_ALL;
		StringBuffer q = new StringBuffer(query);
		ArrayList<String> listaParametros = new ArrayList<String>();
		if(filtro != null) {
			if(filtro.getCodigo() != null && !filtro.getCodigo().equals("")) {
				q.append(" AND UPPER(CODIGO) LIKE CONCAT('%', UPPER(?),'%')");
				listaParametros.add(filtro.getCodigo());
			}
			if(filtro.getDescripcion() != null && !filtro.getDescripcion().equals("")) {
				q.append(" AND UPPER(DESCRIPCION) LIKE CONCAT('%', UPPER(?),'%')");
				listaParametros.add(filtro.getDescripcion());
			}
		}
		this.query = q.toString();
		return listaParametros.toArray(new String[0]);
	}
	
	



}
