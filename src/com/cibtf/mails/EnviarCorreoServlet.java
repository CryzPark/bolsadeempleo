package com.cibtf.mails;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cibtf.dao.CorreoDAO;

/**
 * Servlet implementation class EnviarCorreoServlet
 */
@WebServlet("/EnviarCorreoServlet")
public class EnviarCorreoServlet extends HttpServlet {
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

		String nombre = request.getParameter("nombreContacto");
		String correo = request.getParameter("correoContacto");
		String asunto = request.getParameter("asuntoContacto");
		String mensaje = request.getParameter("mensajeContacto");
		
		mensaje = " Nombre: "+nombre
				+ "\n Correo: "+correo
				+ "\n Mensaje: "+mensaje;
		System.out.println(mensaje);
		
		CorreoDAO correoDAO = new CorreoDAO();
		String status = correoDAO.enviarCorreoDAOSppt(asunto, mensaje);
		
		request.setAttribute("status", status);
		request.getRequestDispatcher("contacto.jsp").forward(request, response);
		
		
	}

}
