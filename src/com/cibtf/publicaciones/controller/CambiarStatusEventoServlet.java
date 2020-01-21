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
 * Servlet implementation class CambiarStatusEventoServlet
 */
@WebServlet("/CambiarStatusEventoServlet")
public class CambiarStatusEventoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

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
		
		String sql = "UPDATE eventos SET status_evento=? WHERE id_evento=?";
		
		PreparedStatement stmnt = null;
		int nRegistros = 0;
		


		int idEvento = Integer.parseInt(request.getParameter("idEvento"));
		int statusEvento = Integer.parseInt(request.getParameter("statusEvento"));
		
		if(statusEvento == 0) {
			statusEvento = 1;
		}else if(statusEvento == 1) {
			statusEvento =0;
		}
		
		
		try {
			//preparado de PreparedStatement
			stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, statusEvento);
			stmnt.setInt(2, idEvento);
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
