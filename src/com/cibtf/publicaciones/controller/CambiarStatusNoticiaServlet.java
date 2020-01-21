package com.cibtf.publicaciones.controller;

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
import com.cibtf.session.controller.SessionUser;

/**
 * Servlet implementation class CambiarStatusNoticiaServlet
 */
@WebServlet("/CambiarStatusNoticiaServlet")
public class CambiarStatusNoticiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

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
		}else if(sessionUser.getRolUsuario().equals("universidad") || sessionUser.getRolUsuario().equals("empresa")) {
			request.getRequestDispatcher("NotFoundServlet").forward(request, response);
		}
		//Fin Validar Sesión y Rol
		
		Connection conn = Conexion.getConnection();
						
		String sql = "UPDATE noticias SET status_noticia=? WHERE id_noticia=?";
		
		PreparedStatement stmnt = null;
		int nRegistros = 0;
		


		int idNoticia = Integer.parseInt(request.getParameter("idNoticia"));
		int statusNoticia= Integer.parseInt(request.getParameter("statusNoticia"));
		
		if(statusNoticia == 0) {
			statusNoticia = 1;
		}else if(statusNoticia == 1) {
			statusNoticia =0;
		}
		
		
		try {
			//preparado de PreparedStatement
			stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, statusNoticia);
			stmnt.setInt(2, idNoticia);
			//Fin del preparado
			
			//Ejecutamos el query y esperamos un número diferente de cero
			nRegistros = stmnt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			
			if(nRegistros==0) {
				request.setAttribute("status", "error");
			}else {
				request.setAttribute("status", "done");
			}
			
			RequestDispatcher rst = request.getRequestDispatcher("ListarPublicacionesServlet");
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
