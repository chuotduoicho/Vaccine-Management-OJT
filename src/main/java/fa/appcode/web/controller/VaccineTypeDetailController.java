package fa.appcode.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import fa.appcode.common.logging.Logging;
import fa.appcode.services.VaccineTypeServices;
import fa.appcode.services.VaccineTypeServicesImpl;
import fa.appcode.web.entities.VaccineType;
import java.io.PrintWriter;
import javax.servlet.annotation.MultipartConfig;

/**
 * Servlet implementation class VaccineTypeDetailController
 */
@WebServlet("/VaccineTypeDetail")
@MultipartConfig
public class VaccineTypeDetailController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VaccineTypeDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String id = request.getParameter("id");
        VaccineTypeServices vaccineTypeServices = new VaccineTypeServicesImpl();
        VaccineType vaccineType = vaccineTypeServices.findbyCode(id);

        request.setAttribute("vaccinetype", vaccineType);

        HttpSession session = request.getSession(true);
        session.setAttribute("action", "update");

        request.getRequestDispatcher("/views/VaccineTypeDetail.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String statusString = request.getParameter("status");
        boolean status = statusString.equalsIgnoreCase("true");
//        System.out.println(statusString);
//        if (statusString == null) {
//            status = false;
//        } else {
//            status = true;
//        }

        String description = request.getParameter("description");
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
            e.printStackTrace();
            Logging.getLog().warn("No File Input!!!");
        } finally {
            if (fos != null) {
                fos.close();
            }
        }

        VaccineType vaccineType = new VaccineType();
        vaccineType.setId(id);
        vaccineType.setName(name);
        vaccineType.setStatus(status);
        vaccineType.setDescription(description);
        vaccineType.setUrlImage(image);

        HttpSession session = request.getSession();

        String action = session.getAttribute("action").toString();

        VaccineTypeServices vaccineTypeServices = new VaccineTypeServicesImpl();
        
        if ("create".equals(action)) {
			try {
				vaccineTypeServices.save(vaccineType);
				Logging.getLog().info("Create Successfully!!!");
			} catch (Exception e) {
				request.setAttribute("messageID", e.getMessage());
				request.getRequestDispatcher("/views/EmployeeDetail.jsp").forward(request, response);
				Logging.getLog().error("Create Failed!!!");
			}
		} else {
			try {
				vaccineTypeServices.updateVaccineType(vaccineType);
				Logging.getLog().info("Update Successfully!!!");
			} catch (Exception e) {
				request.setAttribute("messageID", e.getMessage());
				request.getRequestDispatcher("/views/EmployeeDetail.jsp").forward(request, response);
				Logging.getLog().error("Update Failed!!!");
			}
		}
        
        
        response.sendRedirect(request.getContextPath() + "/VaccineTypeList");

    }

}
