package com.cibtf.session.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cibtf.connection.Conexion;
import com.cibtf.md5.MD5;


/**
 * Servlet implementation class ValidarConexionServlet
 */
@WebServlet("/ValidarConexionServlet")
public class ValidarConexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Connection conn = Conexion.getConnection();
		
		SessionUser sessionUser = new SessionUser();
				
		String sql = "SELECT * FROM usuarios WHERE correo_usuario = ?";
		String correoUsuario = request.getParameter("correoUsuario");
		String passUsuario =  MD5.getMd5(request.getParameter("passUsuario"));
		
		PreparedStatement stmnt = null;
		ResultSet rs = null;
		
		try {
			stmnt = conn.prepareStatement(sql);
			stmnt.setString(1, correoUsuario);
			rs = stmnt.executeQuery();
			
			while(rs.next()) {
				sessionUser.setIdUsuario(rs.getInt("id_usuario"));
				sessionUser.setNombreUsuario(rs.getString("nombre_usuario"));
				sessionUser.setApellidosUsuario(rs.getString("apellidos_usuario"));
				sessionUser.setCorreoUsuario(rs.getString("correo_usuario"));
				sessionUser.setPassUsuario(rs.getString("password_usuario"));
				sessionUser.setRolUsuario(rs.getString("rol_usuario"));
				sessionUser.setStatusUsuario(rs.getInt("status_usuario"));
				sessionUser.setIdUniversidad(rs.getInt("id_universidad"));
				sessionUser.setIdEmpresa(rs.getInt("id_empresa"));
			}
			

			int statusUsuario = sessionUser.getStatusUsuario();
			System.out.println(sessionUser.toString());
			
			//validar contraseña
			if(correoUsuario.equals(sessionUser.getCorreoUsuario()) && passUsuario.equals(sessionUser.getPassUsuario()) && statusUsuario == 1) {
				
				//Inicio Exitoso
				HttpSession session = request.getSession();
				session.setAttribute("sessionUser", sessionUser);
				
				request.getRequestDispatcher("PanelServlet").forward(request, response);
				
			}else {
				
				if(sessionUser.getCorreoUsuario() == null || statusUsuario == 0) {
					//Correo Incorrecto
					request.setAttribute("error", "correo");
					request.getRequestDispatcher("ErrorLoginServlet").forward(request, response);
				}else {
					
					//Contraseña Incorrecta
					request.setAttribute("error", "contraseña");
					request.getRequestDispatcher("ErrorLoginServlet").forward(request, response);
				}

			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			//Mandar error: desconocido
			request.setAttribute("error", "desconocido");
			request.getRequestDispatcher("ErrorLoginServlet").forward(request, response);
			
			e.printStackTrace();
		}
		
		
	}

}
