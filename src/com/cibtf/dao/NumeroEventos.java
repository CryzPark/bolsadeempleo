package com.cibtf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cibtf.connection.Conexion;

public class NumeroEventos {

	private int numeroEventos;
	
	public NumeroEventos() {
		
	}
	
	public int getNumeroEventos() {
		
		Connection conn = Conexion.getConnection();
		String sql = "SELECT COUNT(status_evento) AS eventos FROM eventos WHERE status_evento = 0";
		
		Statement stmnt = null;
		ResultSet rs = null;
		
		try {
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {
				numeroEventos = rs.getInt("eventos");
				System.out.println("Numero de Eventos: "+numeroEventos);
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
		
		return numeroEventos;
	}
	
}
