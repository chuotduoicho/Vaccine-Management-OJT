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
import fa.appcode.services.EmployeeService;
import fa.appcode.services.EmployeeServiceImpl;
import fa.appcode.web.entities.Employee;

/**
 * Servlet implementation class EmployeeListServletController
 */
@WebServlet("/EmployeeList")
public class EmployeeListServletController extends HttpServlet {
	private EmployeeService employeeService;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeListServletController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		employeeService = new EmployeeServiceImpl();

		List<Employee> employees;

		RequestDispatcher dispatcher = null;

		try {
			employees = employeeService.findAll();

			for (Employee employee : employees) {
				if (employee.getImage() != null && employee.getImage().length != 0) {
					Logging.getLog().info(employee.getImage());
					byte[] encodeBase64 = org.apache.tomcat.util.codec.binary.Base64.encodeBase64(employee.getImage());
					String base64Encoded = new String(encodeBase64, "UTF-8");
					employee.setBase64imageFile(base64Encoded);
				}
			}

			request.setAttribute("employees", employees);
			dispatcher = request.getRequestDispatcher("/views/EmployeeList.jsp");
		} catch (Exception e) {
			dispatcher = request.getRequestDispatcher(request.getContextPath() + "/views/500.jsp");
		}

		// Send Response
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String [] emps = request.getParameterValues("emp[]");
		
		for (String id : emps) {
			employeeService = new EmployeeServiceImpl();
			employeeService.delete(id);
		}

		response.sendRedirect(request.getContextPath() + "/EmployeeList");

	}

}
