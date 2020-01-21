package com.cibtf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cibtf.connection.Conexion;

public class NumeroVacantes {

	private int numeroVacantes;
	
	public NumeroVacantes() {
		
	}
	
	
	public int getNumeroVacantes() {
		
		Connection conn = Conexion.getConnection();
		String sql = "SELECT COUNT(status_vacante) AS vacantes FROM vacantes WHERE status_vacante = 0";
		
		Statement stmnt = null;
		ResultSet rs = null;
		
		try {
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {
				numeroVacantes = rs.getInt("vacantes");
				System.out.println("Numero de Vacantess: "+numeroVacantes);
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
		
		return numeroVacantes;
	}
	
}
