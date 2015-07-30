package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import db.PaymentManager;
import db.TenantManager;
import entities.Payment;
import entities.Tenant;

/**
 * Servlet implementation class TenantREST
 */
@WebServlet("/TenantREST")
public class TenantREST extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ServletsBase servBase = new ServletsBase();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenantREST() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		try {
			
			// Handling request
			Tenant tenant = null;
			Gson gson = new Gson();
			String requestData = servBase.readRequest(request);
			TenantManager tenantMng = new TenantManager();
			tenant = gson.fromJson(requestData, Tenant.class);
			// Updating
			tenantMng.updateTenant(tenant);
			// Responding
			response.setContentType("aplication/json");
			servBase.setSuccessHeaders(response);
			response.sendError(200, "Success!");

			System.out.println("Tenant Updated" + tenant.toString());
		} catch (Exception e) {
			response.setContentType("text/plain");
			response.sendError(500, "Internal server error!");
			System.out.println("Failed updating Tenant!");
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
