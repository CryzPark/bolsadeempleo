package com.cibtf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cibtf.connection.Conexion;
import com.cibtf.model.AdminVacante;

public class VacantesDAO {
	private ArrayList<AdminVacante> vacantesDAO = new ArrayList<AdminVacante>();
	
	public VacantesDAO() {
		
	}
	
	public ArrayList<AdminVacante> getAllVacantesDAO(){
		
		Connection conn = Conexion.getConnection();
		String sql = "SELECT usuarios.id_usuario, usuarios.nombre_usuario, vacantes.* , empresas.nombre_empresa, empresas.correo_empresa, empresas.telefono_empresa FROM usuarios INNER JOIN vacantes ON usuarios.id_usuario = vacantes.id_usuario INNER JOIN empresas ON usuarios.id_empresa = empresas.id_empresa WHERE status_vacante = 1 ORDER BY id_vacante DESC";
		
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
				
				
				vacantesDAO.add(vacante);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception

		}finally {
			try {

				stmnt.close();
				rs.close();
				conn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		
		
		
		return vacantesDAO;
	}
	
	
	public AdminVacante getVacanteDAO(int idVacante) {
		
		Connection conn = Conexion.getConnection();
		String sql = "SELECT usuarios.id_usuario, usuarios.nombre_usuario, vacantes.* , empresas.nombre_empresa, empresas.correo_empresa, empresas.telefono_empresa FROM usuarios INNER JOIN vacantes ON usuarios.id_usuario = vacantes.id_usuario INNER JOIN empresas ON usuarios.id_empresa = empresas.id_empresa WHERE id_vacante = "+idVacante;
		
		Statement stmnt = null;
		ResultSet rs = null;

		AdminVacante vacante = new AdminVacante();
		
		try {
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {

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
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception

		}finally {
			try {

				stmnt.close();
				rs.close();
				conn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return vacante;
	}

}
