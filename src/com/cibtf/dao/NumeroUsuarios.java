package com.cibtf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cibtf.connection.Conexion;

public class NumeroUsuarios {

	private int numeroUsuarios;
	
	public NumeroUsuarios() {
		
	}
	
	public int getNumeroUsuarios() {
		
		Connection conn = Conexion.getConnection();
		String sql = "SELECT COUNT(status_usuario) AS usuarios FROM usuarios WHERE status_usuario = 0";
		
		Statement stmnt = null;
		ResultSet rs = null;
		
		try {
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {
				numeroUsuarios = rs.getInt("usuarios");
				System.out.println("Numero de Usuarios: "+numeroUsuarios);
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
		
		return numeroUsuarios;
	}
	
}
