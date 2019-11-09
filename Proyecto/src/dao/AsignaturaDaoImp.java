package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.ConnectionController;
import model.Asignatura;

public class AsignaturaDaoImp implements AsignaturaDao{
	
	private ConnectionController cc;
	private String query;
	
	public AsignaturaDaoImp() {
		
	}

	@Override
	public Asignatura find(Long cod_asignatura) {
		cc = new ConnectionController();
		ResultSet rs = cc.find(AsignaturaDaoSql.FIND, new String[] {cod_asignatura+""});
		if(rs != null) {
			try {
				Asignatura asignatura = new Asignatura();
				if(rs.next()) {
					asignatura.setCodAsignatura(rs.getLong("COD_ASIGNATURA"));
					asignatura.setNombreAsignatura(rs.getString("NOM_ASIGNATURA"));
					asignatura.setAbreviatura(rs.getString("ABREVIATURA"));
				}
				rs.close();
				return asignatura;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		cc.cerrar();
		return null;
	}

	@Override
	public List<Asignatura> findAll(Asignatura filtro) {
		cc = new ConnectionController();
		String[] params = appendWhere(filtro);
		List<Asignatura> lista = new ArrayList<Asignatura>();
		ResultSet rs  = cc.findAll(query, params);
		if(rs != null) {
			try {
				while(rs.next()) {
					Asignatura asignatura = new Asignatura();
					asignatura.setCodAsignatura(rs.getLong("COD_ASIGNATURA"));
					asignatura.setNombreAsignatura(rs.getString("NOM_ASIGNATURA"));
					asignatura.setAbreviatura(rs.getString("ABREVIATURA"));
					lista.add(asignatura);
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
		cc.add(AsignaturaDaoSql.INSERT_INTO, valores);
		cc.cerrar();
	}

	@Override
	public void update(String[] valores, String cod_asignatura) {
		cc = new ConnectionController();
		cc.update(AsignaturaDaoSql.UPDATE_SET, valores, new String[] {cod_asignatura});
		cc.cerrar(); 
		
	}

	@Override
	public void delete(String cod_asignatura) {
		cc = new ConnectionController();
		cc.delete(AsignaturaDaoSql.DELETE_WHERE, new String[] {cod_asignatura});
		cc.cerrar();
	}
	
	private String[] appendWhere(Asignatura filtro) {
		query = AsignaturaDaoSql.FIND_ALL;
		StringBuffer q = new StringBuffer(query);
		ArrayList<String> listaParametros = new ArrayList<String>();
		if(filtro != null) {
			if(filtro.getCodAsignatura() != null ){
				q.append(" AND COD_ASIGNATURA = ?)");
				listaParametros.add(filtro.getCodAsignatura().toString());
			}
			if(filtro.getNombreAsignatura() != null && !filtro.getNombreAsignatura().equals("")) {
				q.append(" AND UPPER(NOM_ASIGNATURA) LIKE CONCAT('%', UPPER(?),'%')");
				listaParametros.add(filtro.getNombreAsignatura());
			}
			if(filtro.getAbreviatura() != null && !filtro.getAbreviatura().equals("")) {
				q.append(" AND UPPER(ABREVIATURA) LIKE CONCAT('%', UPPER(?),'%')");
				listaParametros.add(filtro.getAbreviatura());
			}
		}
		this.query = q.toString();
		return listaParametros.toArray(new String[0]);
	}
	
	



}
