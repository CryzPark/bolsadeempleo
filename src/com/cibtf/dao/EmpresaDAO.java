package com.cibtf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.cibtf.connection.Conexion;
import com.cibtf.md5.MD5;
import com.cibtf.model.Empresa;

public class EmpresaDAO {
	private String statusRE;
	private String statusRU;
	private String status;
	
	
	public String NuevaEmpresa(Empresa empresa) {
		
		RegistrarEmpresa(empresa);
		if(statusRE.equals("done")) {
			RegistrarUsuario(empresa);
			if(statusRU.equals("done")) {
				status = "done";
				CorreoDAO correoDAO = new CorreoDAO();
				correoDAO.enviarCorreoDAO("Nuevo Usuario Registrado", "Un nuevo usuario ha registrado su empresa, por favor revisalo en el panel \n http://bolsadeempleo.mx/", "bolsaempleo.ad@gmail.com");
			}else {
				status = "error";
			}
		}
		
		
		return status;
	}
	
	public void RegistrarEmpresa(Empresa empresa) {
		Connection conn = Conexion.getConnection();
		String sql = "INSERT INTO empresas VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement stmnt = null;
		int nRegistros = 0;
		
		try {
			
			stmnt = conn.prepareStatement(sql);
			stmnt.setString(1, empresa.getNombreEmpresa());
			stmnt.setString(2, empresa.getTelefonoEmpresa());
			stmnt.setString(3, empresa.getCalleEmpresa());
			stmnt.setString(4, empresa.getNoCalleEmpresa());
			stmnt.setString(5, empresa.getColoniaEmpresa());
			stmnt.setString(6, empresa.getCpEmpresa());
			stmnt.setString(7, empresa.getPaisEmpresa());
			stmnt.setString(8, empresa.getEstadoEmpresa());
			stmnt.setString(9, empresa.getCiudadEmpresa());
			stmnt.setString(10, empresa.getMunicipioEmpresa());
			stmnt.setString(11, empresa.getPaginaEmpresa());
			stmnt.setString(12, empresa.getRazonSocialEmpresa());
			stmnt.setString(13, empresa.getRfcEmpresa());
			stmnt.setString(14, empresa.getCorreoEmpresa());
			
			nRegistros = stmnt.executeUpdate();
			

			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(nRegistros==0) {
				statusRE = "error";
			}else {
				statusRE = "done";
			}
			try {
				stmnt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	
	public void RegistrarUsuario(Empresa empresa) {
		Connection conn = Conexion.getConnection();
		String sql = "INSERT INTO usuarios VALUES(null,?,?,?,?,?,?,?,?)";
		
		PreparedStatement stmnt = null;
		int nRegistros = 0;
		
		try {
			
			stmnt = conn.prepareStatement(sql);
			stmnt.setString(1, empresa.getNombreUsuario());
			stmnt.setString(2, empresa.getApellidosUsuario());
			stmnt.setString(3, empresa.getCorreoUsuario());
			stmnt.setString(4, MD5.getMd5(empresa.getPassUsuario()));
			stmnt.setString(5, "empresa");
			stmnt.setInt(6, empresa.getStatusUsuario());
			stmnt.setInt(7, 0);
			stmnt.setInt(8, getLastEmpresaId());
			
			nRegistros = stmnt.executeUpdate();
			

		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(nRegistros==0) {
				statusRU = "error";
			}else {
				statusRU = "done";
			}
			
			try {
				stmnt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public int getLastEmpresaId() {
		int lastEmpresaId = 0;
		
		Connection conn = Conexion.getConnection();
		String sql = "SELECT id_empresa FROM empresas ORDER BY id_empresa DESC LIMIT 1";
		
		Statement stmnt = null;
		ResultSet rs= null;
		
		try {
			
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {
				lastEmpresaId = rs.getInt("id_empresa");
			}
			
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				conn.close();
				rs.close();
				stmnt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		return lastEmpresaId;
	}

}
