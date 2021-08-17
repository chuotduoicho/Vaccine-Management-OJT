package fa.appcode.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import fa.appcode.common.logging.Logging;
import fa.appcode.services.VaccineService;
import fa.appcode.services.VaccineServiceImpl;
import fa.appcode.web.entities.Vaccine;

/**
 * Servlet implementation class VaccineImportServletController
 */
@WebServlet("/VaccineImportServletController")
public class VaccineImportServletController extends HttpServlet {
	private VaccineService vaccineService;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VaccineImportServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/VaccineImport.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fileName = Paths.get(request.getParameter("file")).toString();
		
		vaccineService = new VaccineServiceImpl();
		try {
			vaccineService.importFromFile(fileName);
			response.sendRedirect(request.getContextPath() +"/ListVaccine");
		}catch(Exception exception){
			request.getRequestDispatcher("/views/VaccineImport.jsp").forward(request, response);
		}
	}

}
