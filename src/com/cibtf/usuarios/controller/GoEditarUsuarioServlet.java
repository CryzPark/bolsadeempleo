package com.cibtf.usuarios.controller;

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

import com.cibtf.session.controller.SessionUser;
import com.cibtf.connection.Conexion;
import com.cibtf.model.Usuario;

/**
 * Servlet implementation class GoEditarServlet
 */
@WebServlet("/GoEditarUsuarioServlet")
public class GoEditarUsuarioServlet extends HttpServlet {
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
		
		Usuario usuario = new Usuario();
		
		String sql = "SELECT * FROM usuarios WHERE id_usuario=?";
		PreparedStatement stmnt = null;
		int idUsuario;
		ResultSet rs = null;
		
		idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		
				
		try {
			
			//Consultar datos de Usuario
			stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, idUsuario);
			rs = stmnt.executeQuery();
			
			while(rs.next()) {
				usuario.setIdUsuario(rs.getInt("id_usuario"));
				usuario.setNombreUsuario(rs.getString("nombre_usuario"));
				usuario.setApellidosUsuario(rs.getString("apellidos_usuario"));
				usuario.setCorreoUsuario(rs.getString("correo_usuario"));
				usuario.setRolUsuario(rs.getString("rol_usuario"));
				usuario.setStatusUsuario(rs.getInt("status_usuario"));
				usuario.setIdUniversidad(rs.getInt("id_universidad"));
				usuario.setIdEmpresa(rs.getInt("id_empresa"));
			}
			
			System.out.println(usuario.toString());
			
			
			request.setAttribute("usuario", usuario);
			
			request.getRequestDispatcher("editar_usuario.jsp").forward(request, response);
			
		
			
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//Cerramos la conexion y colocamos los objetos a disposicion del garbage collector
			try {

				stmnt.close();
				rs.close();
				conn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
	}

}
