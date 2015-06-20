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
import entities.*;
import db.*;

/**
 * Servlet implementation class PropertyData
 */
@WebServlet("/PropertyREST")
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("From properties");
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
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	    response.addHeader("Access-Control-Max-Age", "3600");
	    response.addHeader("Access-Control-Allow-Headers", "x-requested-with");
	    out.println(json);
		}
		catch(Exception e ){
			PrintWriter out = response.getWriter();
			response.setContentType("text/plain");
			response.sendError(500,"Internal server error!");
			
			System.out.println("Internal server Error");
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
