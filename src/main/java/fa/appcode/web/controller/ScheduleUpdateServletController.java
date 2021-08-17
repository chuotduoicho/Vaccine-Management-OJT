package fa.appcode.web.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.appcode.services.ScheduleService;
import fa.appcode.services.ScheduleServiceImpl;
import fa.appcode.web.entities.Vaccine;
import fa.appcode.web.entities.VaccineSchedule;

/**
 * Servlet implementation class ScheduleUpdateController
 */
@WebServlet("/ScheduleUpdateServletController")
public class ScheduleUpdateServletController extends HttpServlet {
	private ScheduleService scheduleService;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleUpdateServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		scheduleService = new ScheduleServiceImpl();
		VaccineSchedule vaccineSchedule;
		List<Vaccine> vaccines;
		RequestDispatcher dispatcher = null;
		
		
		try {
			vaccines = scheduleService.findAllVaccine();
			request.setAttribute("vaccines", vaccines);			
			int scheduleId =Integer.parseInt(request.getParameter("scheduleId")) ;
			request.setAttribute("scheduleId", scheduleId);
			vaccineSchedule = scheduleService.findById(scheduleId);
			request.setAttribute("schedule", vaccineSchedule);
			dispatcher = request.getRequestDispatcher("/views/ScheduleDetail.jsp");
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
		scheduleService = new ScheduleServiceImpl();
		
		List<VaccineSchedule> vaccineSchedules;
		
		RequestDispatcher dispatcher = null;
		DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		try {
			//list data
			vaccineSchedules = scheduleService.findAll();
			request.setAttribute("schedules", vaccineSchedules);
			//get data
			String place = request.getParameter("place");
			String note = request.getParameter("note");
			LocalDate from = LocalDate.parse(request.getParameter("from"), dateTime);
			LocalDate to = LocalDate.parse(request.getParameter("to"), dateTime);
			Vaccine vaccine = new Vaccine();
			vaccine.setId(request.getParameter("vaccineId"));
			int id = Integer.parseInt(request.getParameter("scheduleId"));
			VaccineSchedule vaccineSchedule = new VaccineSchedule(id, vaccine, from, to, place, note);
			scheduleService.create(vaccineSchedule);
			response.sendRedirect(request.getContextPath()+"/ScheduleListServletController");
		} catch (Exception e) {
			dispatcher = request.getRequestDispatcher("/views/500.jsp");
		}
		
		// Send Response
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}
}
