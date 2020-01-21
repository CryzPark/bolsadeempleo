package com.cibtf.panel.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cibtf.connection.Conexion;

/**
 * Servlet implementation class GetImagenEventoServlet
 */
@WebServlet("/GetImagenEventoServlet")
public class GetImagenEventoServlet extends HttpServlet {
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

		int idEvento = Integer.parseInt(request.getParameter("idEvento"));
		String sql = "SELECT imagen_evento FROM eventos WHERE id_evento = "+idEvento;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		response.setContentType("image/*");
		try {
			outputStream = response.getOutputStream();
			Connection conn = Conexion.getConnection();
			PreparedStatement pstmnt = conn.prepareStatement(sql);
			ResultSet rs = pstmnt.executeQuery();
			if(rs.next()) {
				inputStream = rs.getBinaryStream("imagen_evento");
			}
			bufferedInputStream = new BufferedInputStream(inputStream);
			bufferedOutputStream = new BufferedOutputStream(outputStream);
			int i=0;
			while((i=bufferedInputStream.read())!=-1) {
				bufferedOutputStream.write(i);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
