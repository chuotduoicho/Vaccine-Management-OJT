package fa.appcode.web.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.appcode.common.logging.Logging;
import fa.appcode.web.entities.Employee;

/**
 * Servlet Filter implementation class WebApplicationFilter
 */
@WebFilter("/*")
public class WebApplicationFilter implements Filter {

//	List<String> urls = new ArrayList<String>(Arrays.asList("Login", "EmployeeCreate", "EmployeeDetail", "EmployeeList",
//			"ScheduleListServletController", "ScheduleUpdateServletController", "VaccineCreateServletController",
//			"VaccineImportServletController", "ListVaccine", "VaccineTypeCreate", "VaccineTypeDetail",
//			"VaccineTypeList", "VaccineUpdateServletController", "Dashboard.jsp"));

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		Logging.getLog().info("Destroy...");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Logging.getLog().info("Do Filter...");
		
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		
		// Request -> valid -> pass
		String urlCurrent = servletRequest.getRequestURL().toString();
		
		HttpSession session = servletRequest.getSession();
		
		Employee employee = (Employee) session.getAttribute("employee");
		
		Logging.getLog().info(urlCurrent);
		
		if ((urlCurrent.contains("Login")) || urlCurrent.contains("ForgotPassword") || urlCurrent.contains("LoginCheckCode")) {
			if (employee != null) {
				if("logout".equals(servletRequest.getParameter("action"))) {
					chain.doFilter(request, response);
				}
				else {
					servletResponse.sendRedirect(servletRequest.getContextPath() + "/views/Dashboard.jsp");
				}
			} else {
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}
		} else {
			if (employee == null) {
				servletResponse.sendRedirect(servletRequest.getContextPath() + "/views/Login.jsp");
			} else {
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
