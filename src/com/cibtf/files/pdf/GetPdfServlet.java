package com.cibtf.files.pdf;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cibtf.dao.VacantesDAO;
import com.cibtf.model.AdminVacante;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class GetPdfServlet
 */
@WebServlet("/GetPdfServlet")
public class GetPdfServlet extends HttpServlet {
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
		
		int idVacante = Integer.parseInt(request.getParameter("idVacante"));
		
		AdminVacante vacante = new AdminVacante();
		VacantesDAO vacantesDAO = new VacantesDAO();
		vacante = vacantesDAO.getVacanteDAO(idVacante);
		
		Document document = new Document();
		try{
		    response.setContentType("application/pdf");
		    PdfWriter.getInstance(document, response.getOutputStream());
		    document.open();
		    //texto
		    document.add(new Paragraph(vacante.toString()));		    
		}catch(Exception e){
		    e.printStackTrace();
		}
		    document.close();

	}

}
