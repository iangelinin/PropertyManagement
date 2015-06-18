
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PropertyData
 */
@WebServlet("/PropertyData")
public class PropertyData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropertyData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("From properties");
		Property[] properties= DBHelper.getPropsFromDB();
		Payment[] payments = DBHelper.getPaymentsFromDB();
		UserData data = new UserData(properties,payments);
		Gson gson = new Gson();
		String json = gson.toJson(data);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	    response.addHeader("Access-Control-Max-Age", "3600");
	    response.addHeader("Access-Control-Allow-Headers", "x-requested-with");
	    
		
		
	    out.println(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
