package fa.appcode.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.appcode.common.logging.Logging;
import fa.appcode.common.valueobjects.VaccineVo;
import fa.appcode.services.VaccineService;
import fa.appcode.services.VaccineServiceImpl;

/**
 * Servlet implementation class ListVaccine
 */
@WebServlet("/ListVaccine")
public class VaccineListServletController extends HttpServlet {
	private VaccineService vaccineService;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VaccineListServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		vaccineService = new VaccineServiceImpl();
		
		List<VaccineVo> vaccineVos;
		
		RequestDispatcher dispatcher = null;
		
		try {
			vaccineVos = vaccineService.findAll();
			request.setAttribute("vaccineVos", vaccineVos);
			dispatcher = request.getRequestDispatcher("/views/VaccineList.jsp");
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		
		if(dispatcher!=null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		vaccineService = new VaccineServiceImpl();
		
		String[] vaccineIds = request.getParameterValues("vaccine[]");
		
		for (String vaccineId : vaccineIds) {
			vaccineService.makeInactive(vaccineId);
		}
		
		response.sendRedirect(request.getContextPath() + "/ListVaccine");
		
	}

}
