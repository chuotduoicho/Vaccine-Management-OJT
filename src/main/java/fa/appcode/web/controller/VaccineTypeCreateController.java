package fa.appcode.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import fa.appcode.common.logging.Logging;
import fa.appcode.dao.dao.VaccineTypeDAOImpl;
import fa.appcode.services.VaccineTypeServices;
import fa.appcode.services.VaccineTypeServicesImpl;
import fa.appcode.web.entities.VaccineType;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VaccineTypeCreateController
 */
@WebServlet("/VaccineTypeCreate")
public class VaccineTypeCreateController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VaccineTypeCreateController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession(true);
        session.setAttribute("action", "create");

        RequestDispatcher requestDispatcher = null;

        try {
            requestDispatcher = request.getRequestDispatcher("/views/VaccineTypeDetail.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            Logging.getLog().error("Can't redirect!!!");
        }

        if (requestDispatcher != null) {
            requestDispatcher.forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}
