package com.cibtf.empresa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cibtf.dao.EmpresaDAO;
import com.cibtf.model.Empresa;

/**
 * Servlet implementation class RegistroEmpresaServlet
 */
@WebServlet("/RegistrarEmpresaServlet")
public class RegistrarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Empresa empresa = new Empresa();
		
		
		empresa.setCorreoUsuario(request.getParameter("correoUsuario"));
		empresa.setPassUsuario(request.getParameter("passUsuario"));
		empresa.setNombreUsuario(request.getParameter("nombreUsuario"));
		empresa.setApellidosUsuario(request.getParameter("apellidosUsuario"));
		empresa.setNombreEmpresa(request.getParameter("nombreEmpresa"));
		empresa.setTelefonoEmpresa(request.getParameter("telefonoEmpresa"));
		empresa.setCorreoEmpresa(request.getParameter("correoEmpresa"));
		empresa.setCalleEmpresa(request.getParameter("calleEmpresa"));
		empresa.setNoCalleEmpresa(request.getParameter("noCalleEmpresa"));
		empresa.setColoniaEmpresa(request.getParameter("coloniaEmpresa"));
		empresa.setPaisEmpresa(request.getParameter("paisEmpresa"));
		empresa.setCpEmpresa(request.getParameter("cpEmpresa"));
		empresa.setEstadoEmpresa(request.getParameter("estadoEmpresa"));
		empresa.setCiudadEmpresa(request.getParameter("ciudadEmpresa"));
		empresa.setMunicipioEmpresa(request.getParameter("municipioEmpresa"));
		empresa.setPaginaEmpresa(request.getParameter("paginaEmpresa"));
		empresa.setRazonSocialEmpresa(request.getParameter("razonSocialEmpresa"));
		empresa.setRfcEmpresa(request.getParameter("rfcEmpresa"));
		
		EmpresaDAO empresaDAO = new EmpresaDAO();
		
		String status = empresaDAO.NuevaEmpresa(empresa);
		
		request.setAttribute("status", status);
		request.getRequestDispatcher("statusNuevaEmpresa.jsp").forward(request, response);
		
		

		
	}

}
