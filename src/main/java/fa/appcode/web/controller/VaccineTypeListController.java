package fa.appcode.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.appcode.services.VaccineTypeServices;
import fa.appcode.services.VaccineTypeServicesImpl;
import fa.appcode.web.entities.VaccineType;

/**
 * Servlet implementation class VaccineTypeListController
 */
@WebServlet("/VaccineTypeList")
public class VaccineTypeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private VaccineTypeServices services;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VaccineTypeListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<VaccineType> vaccineTypes;
		services = new VaccineTypeServicesImpl();
		RequestDispatcher dispatcher = null;
		try {
			vaccineTypes = services.findAllVaccineType();
			for (VaccineType vaccineType : vaccineTypes) {
				if (vaccineType.getUrlImage() != null && vaccineType.getUrlImage().length != 0) {
					byte[] encodeBase64 = org.apache.tomcat.util.codec.binary.Base64.encodeBase64(vaccineType.getUrlImage());
					String base64Encoded = new String(encodeBase64, "UTF-8");
					vaccineType.setBase64imageFile(base64Encoded);
				}
			}
			request.setAttribute("vaccinetypes", vaccineTypes);
			dispatcher = request.getRequestDispatcher("/views/VaccineTypeList.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		services = new VaccineTypeServicesImpl();
		
		String[] vaccineTypeIds = request.getParameterValues("vaccinetypebox[]");
		
		for (String vaccineTypeId : vaccineTypeIds) {
			services.makeInactive(vaccineTypeId);
		}
		
		response.sendRedirect(request.getContextPath() + "/VaccineTypeList");
	}

}
