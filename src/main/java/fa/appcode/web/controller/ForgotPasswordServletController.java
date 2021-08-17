package fa.appcode.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.function.Consumer;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.appcode.services.EmployeeService;
import fa.appcode.services.EmployeeServiceImpl;
import fa.appcode.web.entities.Employee;


/**
 * Servlet implementation class ForgotPasswordServletController
 */
@WebServlet("/ForgotPasswordServletController")
public class ForgotPasswordServletController extends HttpServlet {
	private EmployeeService employeeService;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("preparing to send message ...");
		String code= randomAlphaNumeric(6);
		String message = "<h1> FPT SOFTWARE ACADEMY </h1>"
		+"Dear, this is message for security check your Vaccine Management account. "
		+"<h3> CODE: " + code +"</h3>";
		String subject = "CodersArea : Confirmation";
		String to = request.getParameter("mail");
		String from = "guzhinatra@gmail.com";
		request.setAttribute("code", code);
		request.setAttribute("email", to);
		request.getRequestDispatcher("/views/LoginCheckCode.jsp").forward(request, response);
		// sendEmail(message,subject,to,from);
		sendAttach(message, subject, to, from);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("preparing to send message ...");
		String code= randomPassword(8);
		String message = "<h1> FPT SOFTWARE ACADEMY </h1>"
		+"Dear, this is message for security check your Vaccine Management account. "
		+"<h3> NEW PASSWORD: " + code +"</h3>";
		String subject = "CodersArea : Confirmation";
		String to = request.getParameter("email");
		String from = "guzhinatra@gmail.com";

		
		employeeService = new EmployeeServiceImpl();
		Employee emp;
		RequestDispatcher dispatcher = null;
		
		
		try {
			emp = employeeService.findEmployeeByEmail(to);
			if(emp != null) {
				emp.setPassword(code);
				employeeService.create(emp);
				// sendEmail(message,subject,to,from);		
				sendAttach(message, subject, to, from);
			}else {
                
			}
		} catch (Exception e) {
			dispatcher = request.getRequestDispatcher("/views/500.jsp");
		}
		
		// Send Response
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	// this is responsible to send the message with attachment
	private static void sendAttach(String message, String subject, String to,
			String from) {
		// Variable for gmail
		String host = "smtp.gmail.com";
		// get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES " + properties);
		// setting important information to properties object
		// host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		// Step 1: to get the session object..
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("guzhinatra@gmail.com",
						"1h0p3123");
			}
		});
		session.setDebug(true);
		// Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);
		try {
			// from email
			m.setFrom(from);
			// adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// adding subject to message
			m.setSubject(subject);
			// attachement..
			// file path
//			String path = "C:\\Users\\Admin\\Downloads\\unnamed.png";
			MimeMultipart mimeMultipart = new MimeMultipart();
			// text
			// file
			MimeBodyPart textMime = new MimeBodyPart();
//			MimeBodyPart fileMime = new MimeBodyPart();
			try {
				textMime.setContent(message,"text/html");
//				File file = new File(path);
//				fileMime.attachFile(file);
				mimeMultipart.addBodyPart(textMime);
//				mimeMultipart.addBodyPart(fileMime);
			} catch (Exception e) {
				e.printStackTrace();
			}
			m.setContent(mimeMultipart);
			// send
			// Step 3 : send the message using Transport class
			Transport.send(m);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Email not correct!");
		}
		System.out.println("Sent success...................");
	}
	
	private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
    private static final String digits = "0123456789"; // 0-9
    private static final String specials = "~=+%^*/()[]{}/!@#$?|";
    private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
    private static final String ALL = alpha + alphaUpperCase + digits + specials;
 
    private static Random generator = new Random();
 
    /**
     * Random string with a-zA-Z0-9, not included special characters
     */
    public static String randomAlphaNumeric(int numberOfCharactor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }
    
    public static String randomPassword(int numberOfCharactor) {
        List<String> result = new ArrayList<>();
        Consumer<String> appendChar = s -> {
            int number = randomNumber(0, s.length() - 1);
            result.add("" + s.charAt(number));
        };
        appendChar.accept(digits);
        appendChar.accept(specials);
        while (result.size() < numberOfCharactor) {
            appendChar.accept(ALL);
        }
        Collections.shuffle(result, generator);
        return String.join("", result);
    }
    public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }
}
