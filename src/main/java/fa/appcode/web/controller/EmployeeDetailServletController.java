package fa.appcode.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import fa.appcode.common.logging.Logging;
import fa.appcode.services.EmployeeService;
import fa.appcode.services.EmployeeServiceImpl;
import fa.appcode.web.entities.Employee;

/**
 * Servlet implementation class EmployeeDetailServletController
 */
@WebServlet("/EmployeeDetail")
@MultipartConfig
public class EmployeeDetailServletController extends HttpServlet {
	private EmployeeService employeeService;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeDetailServletController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		EmployeeService employeeService = new EmployeeServiceImpl();
		Employee employee = employeeService.findEmployeeByID(id);
//		Part filePart = request.getPart(employee.getImage().toString());
//		String fileName = Paths.get(filePart).getFileName().toString();

		RequestDispatcher dispatcher = null;

		try {
			if (employee.getImage() != null && employee.getImage().length != 0) {
				byte[] encodeBase64 = org.apache.tomcat.util.codec.binary.Base64.encodeBase64(employee.getImage());
				String base64Encoded = new String(encodeBase64, "UTF-8");
				employee.setBase64imageFile(base64Encoded);
			}
			
			request.setAttribute("employee", employee);
			request.setAttribute("action", "update");
			dispatcher = request.getRequestDispatcher("/views/EmployeeDetail.jsp");
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

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String genderString = request.getParameter("gender");
		boolean gender;

		if ("Male".equals(genderString)) {
			gender = true;
		} else {
			gender = false;
		}

		String dobString = request.getParameter("dob");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dob = LocalDate.parse(dobString, dtf);

		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String workingPlace = request.getParameter("workingPlace");
		String position = request.getParameter("position");

		Part filePart = request.getPart("img");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		File directory = new File("D:\\DATA");

		if (!directory.exists()) {
			directory.mkdirs();
		}

		FileOutputStream fos = null;
		byte[] image = null;

		try {
			fos = new FileOutputStream(directory.getPath() + "\\" + fileName);
			image = filePart.getInputStream().readAllBytes();
			fos.write(image);
		} catch (Exception e) {
//			byte [] imageUndecoded = Base64.getEncoder().encode(request.getParameter("imageEncode").getBytes("UTF-8"));
//			image = Base64.getDecoder().decode(imageUndecoded);
//			Logging.getLog().info(image.toString());
			e.printStackTrace();
			Logging.getLog().warn("No File Input!!!");
		} finally {
			if (fos != null) {
				fos.close();
			}
		}

		Employee emp = new Employee(id, name, gender, dob, phone, address, email, workingPlace, position, image);
//		Logging.getLog().info(emp.getImage());

		String action = request.getParameter("action");

		employeeService = new EmployeeServiceImpl();
				
		if ("create".equals(action)) {
			try {
				employeeService.create(emp);
				Logging.getLog().info("Create Successfully!!!");
				response.sendRedirect(request.getContextPath() + "/EmployeeList");
			} catch (Exception e) {
				request.setAttribute("messageID", e.getMessage());
				request.setAttribute("employee", emp);
				request.getRequestDispatcher("/views/EmployeeDetail.jsp").forward(request, response);
				Logging.getLog().error("Create Failed!!!");
//				e.printStackTrace();
			}
		} else {
			try {		
				employeeService.update(emp);
				Logging.getLog().info("Update Successfully!!!");
				response.sendRedirect(request.getContextPath() + "/EmployeeList");
			} catch (Exception e) {
				request.setAttribute("messageID", e.getMessage());
				request.setAttribute("employee", emp);
				request.getRequestDispatcher("/views/EmployeeDetail.jsp").forward(request, response);
				Logging.getLog().error("Update Failed!!!");
//				e.printStackTrace();
			}
		}

	}

}
