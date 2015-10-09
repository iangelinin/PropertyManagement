package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entities.*;
import db.*;

/**
 * Servlet implementation class PaymentREST
 */
@WebServlet("/private/PaymentREST")
public class PaymentREST extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletsBase servBase = new ServletsBase();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaymentREST() {
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
			Payment payment = null;
			Gson gson = new Gson();
			String requestData = servBase.readRequest(request);
			PaymentManager paymentMng = new PaymentManager();
			payment = gson.fromJson(requestData, Payment.class);
			// Inserting and getting the ID of the new entry
			int id = paymentMng.insertPayments(payment);
			payment.setId(id);
			// Responding and returning the object
			String json = gson.toJson(payment);
			response.setContentType("application/json");
			out.println(json);
			servBase.setSuccessHeaders(response);

		} catch (Exception e) {

			response.setContentType("text/plain");
			response.sendError(500, "Internal server error!");
			System.out.println("Failed creating new payment!");
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	protected void doPut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			// Handling request
			Payment payment = null;
			Gson gson = new Gson();
			String requestData = servBase.readRequest(request);
			PaymentManager paymentMng = new PaymentManager();
			payment = gson.fromJson(requestData, Payment.class);
			// Updating
			paymentMng.updatePayment(payment);
			// Responding
			response.setContentType("aplication/json");
			response.sendError(200, "Success!");
			servBase.setSuccessHeaders(response);

			System.out.println("Payment Updated" + payment.getId());
		} catch (Exception e) {
			response.setContentType("text/plain");
			response.sendError(500, "Internal server error!");
			System.out.println("Failed updating payment!");
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	protected void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			// Handling request
			String id = request.getParameter("id");
			// Deleting payment
			PaymentManager paymentMng = new PaymentManager();
			paymentMng.deletePayment(id);
			// Responding
			System.out.println("Payment deleted");
			response.setContentType("text/plain");
			response.sendError(200, "Success!");
			servBase.setSuccessHeaders(response);

		} catch (Exception e) {
			response.setContentType("text/plain");
			response.sendError(500, "Internal server error!");
			System.out.println("Failed deletingpayment!");
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

}
