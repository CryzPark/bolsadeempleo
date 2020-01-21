package com.cibtf.publicaciones.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.cibtf.connection.Conexion;
import com.cibtf.model.Evento;
import com.cibtf.session.controller.SessionUser;

/**
 * Servlet implementation class RegistrarEventoServlet
 */
@MultipartConfig
@WebServlet("/RegistrarEventoServlet")
public class RegistrarEventoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Validar Sesión y Rol
		SessionUser sessionUser = new SessionUser();
		
		HttpSession session = request.getSession();
		
		sessionUser = (SessionUser) session.getAttribute("sessionUser");
		if(sessionUser == null) {
			request.setAttribute("error", "noLogin");
			request.getRequestDispatcher("ErrorLoginServlet").forward(request, response);
		}else if(sessionUser.getRolUsuario().equals("empresa")) {
			request.getRequestDispatcher("NotFoundServlet").forward(request, response);
		}
		//Fin Validar Sesión y Rol
		
		Connection conn = Conexion.getConnection();
		
		Evento evento = new Evento();
		
		String sql = "INSERT INTO eventos VALUES (null,?,?,?,?,?,?)";
		
		PreparedStatement stmnt = null;
		int nRegistros = 0;
		
		//Llenamos el objeto Usuario
		evento.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
		evento.setStatusEvento(Integer.parseInt(request.getParameter("statusEvento")));
		evento.setTituloEvento(request.getParameter("tituloEvento"));
		evento.setDescripcionEvento(request.getParameter("descripcionEvento"));
		evento.setFechaEvento(request.getParameter("fechaEvento"));
		//obtenemos la imagen del formulario
		Part part = request.getPart("imagenEvento");
		InputStream imagen = part.getInputStream();
		evento.setImagenEvento(imagen);
		
		//Fin de llenado de objeto
		
		
		try {
			//preparado de PreparedStatement
			stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, evento.getIdUsuario());
			stmnt.setString(2, evento.getTituloEvento());
			stmnt.setString(3, evento.getDescripcionEvento());
			stmnt.setString(4, evento.getFechaEvento());
			stmnt.setBlob(5, evento.getImagenEvento());
			stmnt.setInt(6, evento.getStatusEvento());
			//Fin del preparado
			
			//Ejecutamos el query y esperamos un número diferente de cero
			nRegistros = stmnt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			
			if(nRegistros==0) {
				request.setAttribute("status", "error");
				request.setAttribute("tipoPublicacion", "evento");
			}else {
				request.setAttribute("status", "done");
				request.setAttribute("tipoPublicacion", "evento");
			}
			
			RequestDispatcher rst = request.getRequestDispatcher("nueva_publicacion.jsp");
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
