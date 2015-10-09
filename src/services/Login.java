package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import db.LoginManager;
import db.PaymentManager;
import entities.Payment;
import entities.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletsBase servBase = new ServletsBase();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		try {
			// Handling request
			String email = request.getParameter("username");
			String password = request.getParameter("password");
			User user = new User(email, password);
			// Gson gson = new Gson();
			// String requestData = servBase.readRequest(request);
			LoginManager logMg = new LoginManager();

			// user = gson.fromJson(requestData, User.class);

			// Checking if there exists such user and getting the ID of the user
			System.out.println(user.getEmail() + "   " + user.getPassword());
			user.setUser_id(logMg.checkUser(user.getEmail(), user.getPassword()));
			if (user.getUser_id() > 0) {
				request.getSession().setAttribute("user", user);
				response.sendRedirect("private/main.html");

			} else {
				response.sendRedirect("../error_page.html");
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
