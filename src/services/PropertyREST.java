package services;

import com.google.gson.Gson;








import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.*;
import db.*;

/**
 * Servlet implementation class PropertyData
 */
@WebServlet("/private/PropertyREST")
public class PropertyREST extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropertyREST() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private ServletsBase servBase = new ServletsBase();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("From properties");
		PrintWriter out = response.getWriter();
		try{
		//Getting the data from the DB
		PropertyManager propMng = new PropertyManager();
		PaymentManager payMng = new PaymentManager();
		ArrayList<Property> properties= propMng.getProperties();
		ArrayList<Payment> payments = payMng.getPayments();
		UserData data = new UserData(properties,payments);
		
		//Constructing JSON 
		Gson gson = new Gson();
		String json = gson.toJson(data);
		
		//Writing the response
		HttpSession session = request.getSession();
		session.setAttribute("user", "vane");
		servBase.setSuccessHeaders(response);
	    out.println(json);
		}
		catch(Exception e ){
			
			response.setContentType("text/plain");
			response.sendError(500,"Internal server error!");
			
			System.out.println("Internal server Error");
			e.printStackTrace();
		}
		finally{
			out.close();
		}
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		try {
			//Testing sessions
			HttpSession session = request.getSession();
			String user = (String) session.getAttribute("user");
			System.out.println(user);
			// Handling request
			Property property = null;
			Gson gson = new Gson();
			String requestData = servBase.readRequest(request);
			PropertyManager propMng = new PropertyManager();
			property = gson.fromJson(requestData, Property.class);
			// Updating
			propMng.updateProperty(property);
			// Responding
			response.setContentType("aplication/json");
			servBase.setSuccessHeaders(response);
			response.sendError(200, "Success!");

			System.out.println("Property Updated");
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			// Handling request
			NewProperty newProperty = null;
			Gson gson = new Gson();
			String requestData = servBase.readRequest(request);
			TenantManager tenantMng = new TenantManager();
			PropertyManager propMng = new PropertyManager();
			RentsManager rentsMng = new RentsManager();
			newProperty = gson.fromJson(requestData, NewProperty.class);
			// Inserting and getting the ID of the new entry
			newProperty.setProperty(propMng.insertProperty(newProperty.getProperty()));
			newProperty.setTenant(tenantMng.insertTenant(newProperty.getTenant()));
			newProperty.setRentsId(rentsMng.insertRents(newProperty.getTenant(), newProperty.getProperty() ));
			// Responding and returning the object
			String json = gson.toJson(newProperty);
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

}
