package com.cibtf.vacantes.controller;

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

import com.cibtf.connection.Conexion;
import com.cibtf.model.Carrera;
import com.cibtf.session.controller.SessionUser;

/**
 * Servlet implementation class GoRegistrarVacanteServlet
 */
@WebServlet("/GoRegistrarVacanteServlet")
public class GoRegistrarVacanteServlet extends HttpServlet {
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
		}else if(sessionUser.getRolUsuario().equals("universidad") || sessionUser.getRolUsuario().equals("admin")) {
			request.getRequestDispatcher("NotFoundServlet").forward(request, response);
		}
		
		//Fin Validar Sesión y Rol
		
		
		Connection conn = Conexion.getConnection();
		
		ArrayList<Carrera> carreras = new ArrayList<Carrera>();
		
		String sql = "SELECT * FROM carreras";
		Statement stmnt = null;
		ResultSet rs = null;
		
		try {
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {
				Carrera carrera = new Carrera();
				carrera.setIdCarrera(rs.getInt("id_carrera"));
				carrera.setNombreCarrera(rs.getString("nombre_carrera"));
				
				carreras.add(carrera);
				System.out.println(carrera.toString());
				
			}

			request.setAttribute("listaCarreras", carreras);
			
			RequestDispatcher rd = request.getRequestDispatcher("nueva_vacante.jsp");
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
