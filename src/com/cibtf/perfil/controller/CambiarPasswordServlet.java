package com.cibtf.perfil.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cibtf.connection.Conexion;
import com.cibtf.md5.MD5;
import com.cibtf.session.controller.SessionUser;

/**
 * Servlet implementation class CambiarPasswordServlet
 */
@WebServlet("/CambiarPasswordServlet")
public class CambiarPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Validar Sesión y Rol
		SessionUser sessionUser = new SessionUser();
		
		HttpSession session = request.getSession();
		
		sessionUser = (SessionUser) session.getAttribute("sessionUser");
		if(sessionUser == null) {
			request.setAttribute("error", "noLogin");
			request.getRequestDispatcher("ErrorLoginServlet").forward(request, response);
		}
		//Fin Validar Sesión y Rol
		
		
		Connection conn = Conexion.getConnection();
		
		String sql = "UPDATE usuarios SET password_usuario = ? WHERE id_usuario = ?";
		
		PreparedStatement stmnt = null;
		int nRegistros = 0;
		
		String oldPass = request.getParameter("oldPass");
		String newPass = request.getParameter("newPass");
		String md5Pass = MD5.getMd5(oldPass);
		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		
		
		

		
		try {

			stmnt = conn.prepareStatement(sql);
			if(md5Pass.equals(sessionUser.getPassUsuario())) {
				//preparado de PreparedStatement
				stmnt.setString(1, MD5.getMd5(newPass));
				stmnt.setInt(2, idUsuario);
				//Fin del preparado
				
				//Ejecutamos el query y esperamos un número diferente de cero
				nRegistros = stmnt.executeUpdate();

			}

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			
			if(nRegistros==0) {
				request.setAttribute("status", "error");
			}else {
				request.setAttribute("status", "done");
			}
			
			RequestDispatcher rst = request.getRequestDispatcher("MiPerfilServlet");
			rst.forward(request, response);
			try {
				
				stmnt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
