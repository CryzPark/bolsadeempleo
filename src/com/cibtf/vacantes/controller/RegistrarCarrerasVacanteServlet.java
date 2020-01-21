package com.cibtf.vacantes.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import com.cibtf.model.VacanteCarrera;
import com.cibtf.session.controller.SessionUser;

/**
 * Servlet implementation class RegistrarCarrerasVacanteServlet
 */
@WebServlet("/RegistrarCarrerasVacanteServlet")
public class RegistrarCarrerasVacanteServlet extends HttpServlet {
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
		}else if(sessionUser.getRolUsuario().equals("universidad") || sessionUser.getRolUsuario().equals("admin")) {
			request.getRequestDispatcher("NotFoundServlet").forward(request, response);
		}
		
		//Fin Validar Sesión y Rol
		
		Connection conn = Conexion.getConnection();
		
		ArrayList<VacanteCarrera> vacantesCarreas = new ArrayList<VacanteCarrera>();
		VacanteCarrera vacanteCarrera = new VacanteCarrera();
		
		String sql = "SELECT id_vacante FROM vacantes ORDER BY id_vacante DESC LIMIT 1";
		Statement stmnt = null;
		PreparedStatement stmnt2 = null;
		ResultSet rs = null;
		int nRegistros = 0;
		int idVacante = 0;
		
		//Recibimos las carreras
		String carrerasSelect[] = request.getParameterValues("listaCarrerasVacantes") ;
		
		//fin recibir carreras
		
		
		try {
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {
				idVacante = rs.getInt("id_vacante");
			}
			
			for(String a: carrerasSelect) {
				vacanteCarrera.setIdVacante(idVacante);
				vacanteCarrera.setIdCarrera(Integer.parseInt(a));
				vacantesCarreas.add(vacanteCarrera);
			}

			sql = "INSERT INTO vacantes_carreras VALUES(?,?)";
			
			stmnt2 = conn.prepareStatement(sql);
			
			for(VacanteCarrera carrera : vacantesCarreas) {
				stmnt2.setInt(1, carrera.getIdVacante());
				stmnt2.setInt(2, carrera.getIdCarrera());
				nRegistros = stmnt2.executeUpdate();
				System.out.println();
			}
			
			
			RequestDispatcher rd = request.getRequestDispatcher("GoRegistrarVacanteServlet");
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
