package com.cibtf.perfil.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cibtf.connection.Conexion;
import com.cibtf.model.Perfil;
import com.cibtf.session.controller.SessionUser;

/**
 * Servlet implementation class MiPerfilServlet
 */
@WebServlet("/MiPerfilServlet")
public class MiPerfilServlet extends HttpServlet {
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
		}
		//Fin Validar Sesión y Rol
		
		Connection conn = Conexion.getConnection();
		
		Perfil perfil = new Perfil();
		
		String sql = "SELECT usuarios.*, empresas.correo_empresa, empresas.telefono_empresa, empresas.nombre_empresa, universidades.correo_universidad, universidades.telefono_universidad, universidades.nombre_universidad FROM usuarios INNER JOIN empresas ON usuarios.id_empresa = empresas.id_empresa INNER JOIN universidades ON usuarios.id_universidad = universidades.id_universidad WHERE id_usuario = "+sessionUser.getIdUsuario();
		Statement stmnt = null;
		ResultSet rs = null;
		

		try {
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {
				perfil.setIdUsuario(rs.getInt("id_usuario"));
				perfil.setRolUsuario(rs.getString("rol_usuario"));
				perfil.setNombreUsuario(rs.getString("nombre_usuario"));
				perfil.setApellidosUsuario(rs.getString("apellidos_usuario"));
				perfil.setCorreoUsuario(rs.getString("correo_usuario"));
				perfil.setNombreEmpresaUsuario(rs.getString("nombre_empresa"));
				perfil.setNombreUniversidadUsuario(rs.getString("nombre_universidad"));
				perfil.setTelefonoEmpresaUsuario(rs.getString("telefono_empresa"));
				perfil.setTelefonoUniversidadUsuario(rs.getString("telefono_universidad"));
				perfil.setCorreoEmpresaUsuario(rs.getString("correo_empresa"));
				perfil.setCorreoUniversidadUsuario(rs.getString("correo_universidad"));


				System.out.println(perfil.toString());
				
			}

			request.setAttribute("usuario", perfil);
			
			RequestDispatcher rd = request.getRequestDispatcher("perfil.jsp");
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
