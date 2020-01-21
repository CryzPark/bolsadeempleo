package com.cibtf.publicaciones.controller;

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
import com.cibtf.model.Evento;
import com.cibtf.model.Noticia;
import com.cibtf.session.controller.SessionUser;

/**
 * Servlet implementation class ListarPublicacionesServlet
 */
@WebServlet("/ListarPublicacionesServlet")
public class ListarPublicacionesServlet extends HttpServlet {
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
				}else if(sessionUser.getRolUsuario().equals("empresa")) {
					request.getRequestDispatcher("NotFoundServlet").forward(request, response);
				}
				//Fin Validar Sesión y Rol
				
				Connection conn = Conexion.getConnection();
				
				ArrayList<Evento> listaEventos = new ArrayList<Evento>();
				ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
				
				
				String sql = "SELECT usuarios.id_usuario, usuarios.nombre_usuario, eventos.*, universidades.nombre_universidad FROM usuarios INNER JOIN eventos ON usuarios.id_usuario = eventos.id_usuario INNER JOIN universidades ON usuarios.id_universidad = universidades.id_universidad ORDER BY id_evento DESC";
				Statement stmnt = null;
				ResultSet rs = null;
				
				try {
					
					//llenamos lista Eventos
					stmnt = conn.createStatement();
					rs = stmnt.executeQuery(sql);
					
					while(rs.next()) {
						Evento evento = new Evento();
						evento.setIdUsuario(rs.getInt("id_usuario"));
						evento.setIdEvento(rs.getInt("id_evento"));
						evento.setStatusEvento(rs.getInt("status_evento"));
						evento.setNombreUsuario(rs.getString("nombre_usuario"));
						evento.setUniversidadUsuario(rs.getString("nombre_universidad"));
						evento.setTituloEvento(rs.getString("titulo_evento"));
						evento.setDescripcionEvento(rs.getString("descripcion_evento"));
						evento.setFechaEvento(rs.getString("fecha_evento"));
						
						if(sessionUser.getRolUsuario().equals("universidad")) {
							if(sessionUser.getIdUsuario() == evento.getIdUsuario()) {
								listaEventos.add(evento);
								System.out.println(evento.toString());
							}
						}else {
							listaEventos.add(evento);
							System.out.println(evento.toString());
						}
						

						
					}

					
					//llenamos lista Noticias
					
					sql = "SELECT usuarios.id_usuario, usuarios.nombre_usuario, noticias.*, universidades.nombre_universidad FROM usuarios INNER JOIN noticias ON usuarios.id_usuario = noticias.id_usuario INNER JOIN universidades ON usuarios.id_universidad = universidades.id_universidad ORDER BY id_noticia DESC";
					rs.close();
					rs = stmnt.executeQuery(sql);
					
					while(rs.next()) {
						Noticia noticia = new Noticia();
						noticia.setIdUsuario(rs.getInt("id_usuario"));
						noticia.setIdNoticia(rs.getInt("id_noticia"));
						noticia.setStatusNoticia(rs.getInt("status_noticia"));
						noticia.setNombreUsuario(rs.getString("nombre_usuario"));
						noticia.setUniversidadUsuario(rs.getString("nombre_universidad"));
						noticia.setTituloNoticia(rs.getString("titulo_noticia"));
						noticia.setDescripcionNoticia(rs.getString("descripcion_noticia"));
						noticia.setFechaNoticia(rs.getString("fecha_noticia"));
						

						
						if(sessionUser.getRolUsuario().equals("universidad")) {
							if(sessionUser.getIdUsuario() == noticia.getIdUsuario()) {
								listaNoticias.add(noticia);
								System.out.println(noticia.toString());
							}
						}else {
							listaNoticias.add(noticia);
							System.out.println(noticia.toString());
						}
						
					}

					
					request.setAttribute("listaEventos", listaEventos);
					request.setAttribute("listaNoticias", listaNoticias);
					
					RequestDispatcher rd = request.getRequestDispatcher("admin_publicaciones.jsp");
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
