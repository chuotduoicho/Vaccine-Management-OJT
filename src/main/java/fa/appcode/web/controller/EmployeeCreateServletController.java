package fa.appcode.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.appcode.common.logging.Logging;


/**
 * Servlet implementation class EmployeeCreateServletController
 */
@WebServlet("/EmployeeCreate")
public class EmployeeCreateServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeCreateServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("action", "create");

		RequestDispatcher requestDispatcher = null;
		
		try {
			requestDispatcher = request.getRequestDispatcher("/views/EmployeeDetail.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			Logging.getLog().error("Can't redirect!!!");
		}
		
		if (requestDispatcher != null) {
			requestDispatcher.forward(request, response);
		}
		/*
		 * request.getRequestDispatcher("/views/EmployeeDetail.jsp").forward(request,
		 * response);
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * String id = request.getParameter("id"); String name =
		 * request.getParameter("name"); boolean gender;
		 * 
		 * if ("male".equals(request.getParameter("gender"))) { gender = true; } else {
		 * gender = false; }
		 * 
		 * String dobString = request.getParameter("dob");
		 * 
		 * DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd"); LocalDate
		 * dob = LocalDate.parse(dobString, dtf);
		 * 
		 * String phone = request.getParameter("phone"); String address =
		 * request.getParameter("address"); String email =
		 * request.getParameter("email"); String workingPlace =
		 * request.getParameter("workingPlace"); String position =
		 * request.getParameter("position"); String imageString =
		 * request.getParameter("img");
		 * 
		 * byte [] image = imageString.getBytes(StandardCharsets.UTF_8);
		 * 
		 * EmployeeService employeeService = new EmployeeServiceImpl(); Employee emp =
		 * new Employee(id, name, gender, dob, phone, address, email, workingPlace,
		 * position, image);
		 * 
		 * try { employeeService.create(emp);
		 * Logging.getLog().info("Create Successfully!!!"); } catch (Exception e) {
		 * Logging.getLog().error("Create Failed!!!"); e.printStackTrace(); }
		 * 
		 * response.sendRedirect("/views/Dashboard.jsp");
		 */
	}

}
