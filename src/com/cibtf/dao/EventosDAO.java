package com.cibtf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cibtf.connection.Conexion;
import com.cibtf.model.Evento;

public class EventosDAO {
	private ArrayList<Evento> eventosDAO = new ArrayList<Evento>();
	
	public EventosDAO() {
		
	}
	
	public ArrayList<Evento> getAllEventosDAO(){
		
		Connection conn = Conexion.getConnection();
		String sql = "SELECT * FROM eventos WHERE status_evento = 1";
		
		Statement stmnt = null;
		ResultSet rs = null;
		
		try {
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {
				Evento evento = new Evento();
				evento.setIdEvento(rs.getInt("id_evento"));
				evento.setTituloEvento(rs.getString("titulo_evento"));
				evento.setDescripcionEvento(rs.getString("descripcion_evento"));
				
				eventosDAO.add(evento);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception

		}finally {
			try {

				stmnt.close();
				rs.close();
				conn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		
		
		
		
		return eventosDAO;
	}
}
