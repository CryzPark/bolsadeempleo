package com.cibtf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cibtf.connection.Conexion;
import com.cibtf.model.Noticia;

public class NoticiasDAO {
private ArrayList<Noticia> noticiasDAO = new ArrayList<Noticia>();
	
	public NoticiasDAO() {
		
	}
	
	public ArrayList<Noticia> getAllNoticiasDAO(){
		
		Connection conn = Conexion.getConnection();
		String sql = "SELECT * FROM noticias WHERE status_noticia = 1";
		
		Statement stmnt = null;
		ResultSet rs = null;
		
		try {
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {
				Noticia noticia = new Noticia();
				noticia.setIdNoticia(rs.getInt("id_noticia"));
				noticia.setTituloNoticia(rs.getString("titulo_noticia"));
				noticia.setDescripcionNoticia(rs.getString("descripcion_noticia"));
				
				noticiasDAO.add(noticia);
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
		
		
		
		return noticiasDAO;
	}
}
