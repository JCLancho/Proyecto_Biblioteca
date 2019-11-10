package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.ConnectionController;
import model.Historico;

public class HistoricoDaoImp implements HistoricoDao{
	
	private ConnectionController cc;
	private String query;
	
	public HistoricoDaoImp() {
		
	}


	@Override
	public List<Historico> findAll(Historico filtro) {
		cc = new ConnectionController();
		String[] params = appendWhere(filtro);
		List<Historico> lista = new ArrayList<Historico>();
		ResultSet rs  = cc.findAll(query, params);
		if(rs != null) {
			try {
				while(rs.next()) {
					Historico historico = new Historico();
					
					lista.add(historico);
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
		cc.add(HistoricoDaoSql.INSERT_INTO, valores);
		cc.cerrar();
	}
	
	private String[] appendWhere(Historico filtro) {
		query = HistoricoDaoSql.FIND_ALL;
		StringBuffer q = new StringBuffer(query);
		ArrayList<String> listaParametros = new ArrayList<String>();
		if(filtro != null) {
			
		}
		this.query = q.toString();
		return listaParametros.toArray(new String[0]);
	}
	
	



}
