package services;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletsBase {
	public ServletsBase(){
		
	}
	public String readRequest(HttpServletRequest request) throws IOException{
		StringBuffer sb = new StringBuffer();

		BufferedReader reader = request.getReader();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line);

		}
		return sb.toString();
	}
	public void setSuccessHeaders(HttpServletResponse response) throws IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods",
				"POST, GET, OPTIONS, DELETE");
		response.addHeader("Access-Control-Max-Age", "3600");
		response.addHeader("Access-Control-Allow-Headers",
				"x-requested-with");

		
		
	}

}
