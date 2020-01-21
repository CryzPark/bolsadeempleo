package com.cibtf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cibtf.connection.Conexion;

public class NumeroNoticias {

	private int numeroNoticias;
	
	public NumeroNoticias() {
		
	}
	
	public int getNumeroNoticias() {
		
		Connection conn = Conexion.getConnection();
		String sql = "SELECT COUNT(status_noticia) AS noticias FROM noticias WHERE status_noticia = 0";
		
		Statement stmnt = null;
		ResultSet rs = null;
		
		try {
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {
				numeroNoticias = rs.getInt("noticias");
				System.out.println("Numero de Noticias: "+numeroNoticias);
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
		
		return numeroNoticias;
	}
	
	
}
