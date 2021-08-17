package fa.appcode.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.appcode.services.ScheduleService;
import fa.appcode.services.ScheduleServiceImpl;
import fa.appcode.web.entities.VaccineSchedule;

/**
 * Servlet implementation class ScheduleList
 */
@WebServlet("/ScheduleListServletController")
public class ScheduleListServletController extends HttpServlet {
	private ScheduleService scheduleService;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleListServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		scheduleService = new ScheduleServiceImpl();
		
		List<VaccineSchedule> vaccineSchedules;
		
		RequestDispatcher dispatcher = null;
		
		try {
			vaccineSchedules = scheduleService.findAll();
			request.setAttribute("schedules", vaccineSchedules);
			dispatcher = request.getRequestDispatcher("/views/ScheduleList.jsp");
		} catch (Exception e) {
			dispatcher = request.getRequestDispatcher("/views/500.jsp");
		}
		
		// Send Response
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
