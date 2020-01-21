package com.cibtf.usuarios.controller;

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
import com.cibtf.model.Usuario;
import com.cibtf.session.controller.SessionUser;

/**
 * Servlet implementation class EditarUsuarioServlet
 */
@WebServlet("/EditarUsuarioServlet")
public class EditarUsuarioServlet extends HttpServlet {
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
		}else if(sessionUser.getRolUsuario().equals("universidad") || sessionUser.getRolUsuario().equals("empresa")) {
			request.getRequestDispatcher("NotFoundServlet").forward(request, response);
		}
		//Fin Validar Sesión y Rol
		
		Connection conn = Conexion.getConnection();
		
		Usuario usuario = new Usuario();
		
		String sql = "UPDATE usuarios SET nombre_usuario=? , apellidos_usuario=? , correo_usuario=? , rol_usuario=?  , status_usuario=? , id_universidad=? , id_empresa=? WHERE id_usuario=?";
		
		PreparedStatement stmnt = null;
		int nRegistros = 0;
		
		
		
		try {
			
			//Llenamos el objeto Usuario
			usuario.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
			usuario.setNombreUsuario(request.getParameter("nombreUsuario"));
			usuario.setApellidosUsuario(request.getParameter("apellidosUsuario"));
			usuario.setCorreoUsuario(request.getParameter("correoUsuario"));
			usuario.setRolUsuario(request.getParameter("rolUsuario"));
			usuario.setStatusUsuario(Integer.parseInt(request.getParameter("statusUsuario")));
			usuario.setIdUniversidad(Integer.parseInt(request.getParameter("idUniversidad")));
			usuario.setIdEmpresa(Integer.parseInt(request.getParameter("idEmpresa")));
			//Fin de llenado de objeto
			
			//preparado de PreparedStatement
			stmnt = conn.prepareStatement(sql);
			stmnt.setString(1, usuario.getNombreUsuario());
			stmnt.setString(2, usuario.getApellidosUsuario());
			stmnt.setString(3, usuario.getCorreoUsuario());
			stmnt.setString(4, usuario.getRolUsuario());
			stmnt.setInt(5, usuario.getStatusUsuario());
			stmnt.setInt(6, usuario.getIdUniversidad());
			stmnt.setInt(7, usuario.getIdEmpresa());
			stmnt.setInt(8, usuario.getIdUsuario());
			//Fin del preparado
			
			//Ejecutamos el query y esperamos un número diferente de cero
			nRegistros = stmnt.executeUpdate();
			
			request.setAttribute("usuario", usuario);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			
			if(nRegistros==0) {
				request.setAttribute("status", "error");
				request.setAttribute("usuario", usuario);
			}else {
				request.setAttribute("status", "done");
			}
			
			RequestDispatcher rst = request.getRequestDispatcher("editar_usuario.jsp");
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
