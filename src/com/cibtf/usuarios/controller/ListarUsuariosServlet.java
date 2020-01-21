package com.cibtf.usuarios.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class ListarUsuariosServlet
 */
@WebServlet("/ListarUsuariosServlet")
public class ListarUsuariosServlet extends HttpServlet {
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
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		String sql = "SELECT usuarios.*, universidades.nombre_universidad, empresas.nombre_empresa FROM usuarios INNER JOIN universidades ON usuarios.id_universidad = universidades.id_universidad INNER JOIN empresas ON usuarios.id_empresa = empresas.id_empresa ORDER BY id_usuario DESC";
		Statement stmnt = null;
		ResultSet rs = null;
		
		try {
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {
				if(rs.getInt("id_usuario") != 1000) {
					Usuario usuario = new Usuario();
					usuario.setIdUsuario(rs.getInt("id_usuario"));
					usuario.setNombreUsuario(rs.getString("nombre_usuario"));
					usuario.setApellidosUsuario(rs.getString("apellidos_usuario"));
					usuario.setCorreoUsuario(rs.getString("correo_usuario"));
					usuario.setPassUsuario(rs.getString("password_usuario"));
					usuario.setRolUsuario(rs.getString("rol_usuario"));
					usuario.setStatusUsuario(rs.getInt("status_usuario"));
					usuario.setIdUniversidad(rs.getInt("id_universidad"));
					usuario.setIdEmpresa(rs.getInt("id_empresa"));
					usuario.setNombreUniversidad(rs.getString("nombre_universidad"));
					usuario.setNombreEmpresa(rs.getString("nombre_empresa"));
					
					usuarios.add(usuario);
					System.out.println(usuario.toString());
				}
				
			}

			request.setAttribute("usuarios", usuarios);
			
			RequestDispatcher rd = request.getRequestDispatcher("admin_usuarios.jsp");
			rd.forward(request, response);
			
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
