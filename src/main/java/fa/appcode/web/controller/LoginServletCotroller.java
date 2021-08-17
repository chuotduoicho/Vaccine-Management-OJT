package fa.appcode.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.appcode.services.EmployeeService;
import fa.appcode.services.EmployeeServiceImpl;
import fa.appcode.web.entities.Employee;

/**
 * Servlet implementation class LoginServletCotroller
 */
@WebServlet("/Login")
public class LoginServletCotroller extends HttpServlet {
	EmployeeService employeeService;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServletCotroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		response.sendRedirect(request.getContextPath() + "/views/Login.jsp");
		
		String action = request.getParameter("action");
		if ("logout".equals(action)) {
		      session.removeAttribute("employee");
		}
		else {    
			response.sendRedirect("views/Login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		employeeService = new EmployeeServiceImpl();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			Employee employee = employeeService.checkLogin(username, password);
			if(employee!=null) {
				session.setAttribute("employee", employee);
				response.sendRedirect(request.getContextPath() + "/views/Dashboard.jsp");
			}
			else {
				request.setAttribute("message", "Login failed!! Please check your username or password again!!");
				request.getRequestDispatcher("/views/Login.jsp").forward(request, response);
			}
		}catch(Exception exception) {
			exception.printStackTrace();
			request.setAttribute("message", "Login failed!! Please check your username or password again!!");
			request.getRequestDispatcher("/views/Login.jsp").forward(request, response);
		}
	}

}
