package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.LoginManager;
import entities.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletsBase servBase = new ServletsBase();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		try {
			// Handling request
			String email = request.getParameter("username");
			String password = request.getParameter("password");
			User user = new User(email, password);
			
			LoginManager logMg = new LoginManager();

			// user = gson.fromJson(requestData, User.class);

			// Checking if there exists such user and getting the ID of the user
			System.out.println(user.getEmail() + "   " + user.getPassword());
			user.setUser_id(logMg.insertUser(user.getEmail(), user.getPassword()));
			if (user.getUser_id() > 0) {
				HttpSession session = request.getSession(true); 
				session.invalidate();
				request.getSession(true).setAttribute("user_id", user.getUser_id());
				response.sendRedirect("http://54.218.118.129:8080/PropMngApp/private/main.html");

			} else {
				String loginURL = ((HttpServletRequest) request).getContextPath() + "/error_page.html";
				response.sendRedirect(loginURL);
			}
		} catch (Exception e) {

			response.setContentType("text/plain");
			
			response.sendError(500, "Internal server error!");
			System.out.println("Failed creating new payment!");
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
}
