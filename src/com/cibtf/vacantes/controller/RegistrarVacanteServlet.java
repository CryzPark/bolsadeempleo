package com.cibtf.vacantes.controller;

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
import com.cibtf.model.Vacante;
import com.cibtf.session.controller.SessionUser;

/**
 * Servlet implementation class RegistrarVacante
 */
@WebServlet("/RegistrarVacanteServlet")
public class RegistrarVacanteServlet extends HttpServlet {
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
		}else if(sessionUser.getRolUsuario().equals("universidad") || sessionUser.getRolUsuario().equals("admin")) {
			request.getRequestDispatcher("NotFoundServlet").forward(request, response);
		}
		
		//Fin Validar Sesión y Rol
		

		Connection conn = Conexion.getConnection();
		
		Vacante vacante = new Vacante();
		
		String sql = "INSERT INTO vacantes VALUES (null,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement stmnt = null;
		int nRegistros = 0;
	
		//		listaCarrerasVacantes
		//Llenamos el objeto Usuario
		vacante.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
		vacante.setStatusVacante(Integer.parseInt(request.getParameter("statusVacante")));
		vacante.setFuncionVacante(request.getParameter("funcionVacante"));
		vacante.setComisionesUsuario(request.getParameter("comisionesVacante"));
		vacante.setConocimientosVacante(request.getParameter("conocimientosVacante"));
		vacante.setDiasLaboralesVacante(request.getParameter("diasLaboralesVacante"));
		vacante.setEdadesVacante(request.getParameter("edadesVacante"));
		vacante.setEscolaridadVacante(request.getParameter("escolaridadVacante"));
		vacante.setEstadoCivilVacante(request.getParameter("estadoCivilVacante"));
		vacante.setExperienciaVacante(request.getParameter("experienciaVacante"));
		vacante.setSexoVacante(request.getParameter("sexoVacante"));
		vacante.setHabilidadesVacante(request.getParameter("habilidadesVacante"));
		vacante.setHorariosVacante(request.getParameter("horariosVacante"));
		vacante.setTurnosVacante(request.getParameter("turnosVacante"));
		vacante.setIdiomasVacante(request.getParameter("idiomasVacante"));
		vacante.setNombreVacante(request.getParameter("nombreVacante"));
		vacante.setPlazasVacante(request.getParameter("plazasVacante"));
		vacante.setDispViajeVacante(request.getParameter("dispViajeVacante"));
		vacante.setSueldoVacante(request.getParameter("sueldoVacante"));
		vacante.setPrestacionesVacante(request.getParameter("prestacionesVacante"));
		vacante.setDescripcionVacante(request.getParameter("descripcionVacante"));
		//Fin de llenado de objeto
		
		
		
		try {
			//preparado de PreparedStatement
			stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, vacante.getIdUsuario());
			stmnt.setInt(2, vacante.getStatusVacante());
			stmnt.setString(3, vacante.getFuncionVacante());
			stmnt.setString(4, vacante.getComisionesUsuario());
			stmnt.setString(5, vacante.getConocimientosVacante());
			stmnt.setString(6, vacante.getDiasLaboralesVacante());
			stmnt.setString(7, vacante.getEdadesVacante());
			stmnt.setString(8, vacante.getEscolaridadVacante());
			stmnt.setString(9, vacante.getEstadoCivilVacante());
			stmnt.setString(10, vacante.getExperienciaVacante());
			stmnt.setString(11, vacante.getSexoVacante());
			stmnt.setString(12, vacante.getHabilidadesVacante());
			stmnt.setString(13, vacante.getHorariosVacante());
			stmnt.setString(14, vacante.getTurnosVacante());
			stmnt.setString(15, vacante.getIdiomasVacante());
			stmnt.setString(16, vacante.getNombreVacante());
			stmnt.setString(17, vacante.getPlazasVacante());
			stmnt.setString(18, vacante.getDispViajeVacante());
			stmnt.setString(19, vacante.getSueldoVacante());
			stmnt.setString(20, vacante.getPrestacionesVacante());
			stmnt.setString(21, vacante.getDescripcionVacante());
			//Fin del preparado
			
			//Ejecutamos el query y esperamos un número diferente de cero
			nRegistros = stmnt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if(nRegistros==0) {
				request.setAttribute("status", "error");
				RequestDispatcher rst = request.getRequestDispatcher("nueva_vacante.jsp");
				rst.forward(request, response);
			}else {
				request.setAttribute("status", "done");
				RequestDispatcher rst = request.getRequestDispatcher("RegistrarCarrerasVacanteServlet");
				rst.forward(request, response);
			}
			
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
