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
import com.cibtf.model.AdminVacante;
import com.cibtf.session.controller.SessionUser;

/**
 * Servlet implementation class ListarVacantesServlet
 */
@WebServlet("/ListarVacantesServlet")
public class ListarVacantesServlet extends HttpServlet {
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
		}else if(sessionUser.getRolUsuario().equals("universidad")) {
			request.getRequestDispatcher("NotFoundServlet").forward(request, response);
		}
		//Fin Validar Sesión y Rol
		

		Connection conn = Conexion.getConnection();
		
		ArrayList<AdminVacante> adminVacantes = new ArrayList<AdminVacante>();
		
		String sql = "SELECT usuarios.id_usuario, usuarios.nombre_usuario, vacantes.* , empresas.nombre_empresa, empresas.correo_empresa, empresas.telefono_empresa FROM usuarios INNER JOIN vacantes ON usuarios.id_usuario = vacantes.id_usuario INNER JOIN empresas ON usuarios.id_empresa = empresas.id_empresa ORDER BY id_vacante DESC";
		Statement stmnt = null;
		ResultSet rs = null;
		
		try {
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			
			
			while(rs.next()) {
				AdminVacante vacante = new AdminVacante();

				vacante.setIdUsuario(rs.getInt("id_usuario"));
				vacante.setIdVacante(rs.getInt("id_vacante"));
				vacante.setStatusVacante(rs.getInt("status_vacante"));
				vacante.setNombreUsuario(rs.getString("nombre_usuario"));
				vacante.setNombreEmpresa(rs.getString("nombre_empresa"));
				vacante.setCorreoEmpresa(rs.getString("correo_empresa"));
				vacante.setTelefonoEmpresa(rs.getString("telefono_empresa"));
				vacante.setNombreVacante(rs.getString("nombre_vacante"));
				vacante.setFuncionVacante(rs.getString("funcion_vacante"));
				vacante.setDescripcionVacante(rs.getString("descripcion_vacante"));
				vacante.setPlazasVacante(rs.getString("plazas_vacante"));
				vacante.setHabilidadesVacante(rs.getString("habilidades_vacante"));
				vacante.setExperienciaVacante(rs.getString("experiencia_vacante"));
				vacante.setEscolaridadVacante(rs.getString("escolaridad_vacante"));
				vacante.setConocimientosVacante(rs.getString("conocimientos_vacante"));
				vacante.setDiasLaboralesVacante(rs.getString("dias_laborales_vacante"));
				vacante.setIdiomasVacante(rs.getString("idiomas_vacante"));
				vacante.setEdadesVacante(rs.getString("edades_vacante"));
				vacante.setSexoVacante(rs.getString("sexo_vacante"));
				vacante.setSueldoVacante(rs.getString("sueldos_vacante"));
				vacante.setPrestacionesVacante(rs.getString("prestaciones_vacante"));
				vacante.setComisionesUsuario(rs.getString("comisiones_vacante"));
				vacante.setDispViajeVacante(rs.getString("disp_viaje_vacante"));
				vacante.setTurnosVacante(rs.getString("turno_vacante"));
				vacante.setHorariosVacante(rs.getString("horarios_vacante"));
				vacante.setEstadoCivilVacante(rs.getString("estado_civil_vacante"));
				
				if(sessionUser.getRolUsuario().equals("empresa")) {
					if(vacante.getIdUsuario() == sessionUser.getIdUsuario()) {
						adminVacantes.add(vacante);
						System.out.println(vacante.toString());
					}
				}else {
					adminVacantes.add(vacante);
					System.out.println(vacante.toString());
				}
				
			}

			request.setAttribute("adminVacantes", adminVacantes);
			
			RequestDispatcher rd = request.getRequestDispatcher("admin_vacantes.jsp");
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
