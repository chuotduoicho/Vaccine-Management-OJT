package fa.appcode.web.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
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
import fa.appcode.services.VaccineTypeServices;
import fa.appcode.services.VaccineTypeServicesImpl;
import fa.appcode.web.entities.Vaccine;
import fa.appcode.web.entities.VaccineType;


/**
 * Servlet implementation class VaccineCreateServletController
 */
@WebServlet("/VaccineCreateServletController")
public class VaccineCreateServletController extends HttpServlet {
	private VaccineService vaccineService;
	private VaccineTypeServices vaccineTypeService;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VaccineCreateServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		vaccineTypeService = new VaccineTypeServicesImpl();
		List<VaccineType> types = vaccineTypeService.findAllVaccineType();
		request.setAttribute("action", "create");
		request.setAttribute("types", types);
		request.getRequestDispatcher("/views/VaccineDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		vaccineService = new VaccineServiceImpl();
		Vaccine vaccine = new Vaccine();
		VaccineType type = new VaccineType();
		type.setId(request.getParameter("typeId"));
		vaccine.setId(request.getParameter("vaccineId"));
		vaccine.setName(request.getParameter("name"));
		vaccine.setStatus(request.getParameter("status").equalsIgnoreCase("true"));
		vaccine.setNumberOfInject(Integer.parseInt(request.getParameter("numberInject")));
		vaccine.setUseage((request.getParameter("usage")));
		vaccine.setContraindication(request.getParameter("contraindication"));
		vaccine.setIndication(request.getParameter("indication"));
		
		String timeBegin = request.getParameter("begin");
		if(!timeBegin.isEmpty()) {
			vaccine.setTimeBegin(LocalDate.parse(timeBegin));
		}
		String timeEnd = request.getParameter("end");
		if(!timeBegin.isEmpty()) {
			vaccine.setTimeBegin(LocalDate.parse(timeEnd));
		}
		vaccine.setOrigin(request.getParameter("origin"));
		vaccine.setType(type);
		try {			
			vaccineService.create(vaccine);
			response.sendRedirect(request.getContextPath() +"/ListVaccine");
		}catch(Exception exception) {
			//exception.printStackTrace();
			vaccineTypeService = new VaccineTypeServicesImpl();
			List<VaccineType> types = vaccineTypeService.findAllVaccineType();
			request.setAttribute("action", "create");
			request.setAttribute("types", types);
			request.setAttribute("error", exception.getMessage());
			request.setAttribute("vaccine", vaccine);
			request.getRequestDispatcher("/views/VaccineDetail.jsp").forward(request, response);
		}
		
		
	}

}
