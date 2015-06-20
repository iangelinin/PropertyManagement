package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseManager {
	protected Connection conn;
	protected Statement stmt;
	public BaseManager() throws ClassNotFoundException, SQLException{
		driverInit();
		this.conn = getConnection();
		this.stmt = conn.createStatement();
	}
	
	private void driverInit() throws ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
	}
	private Connection getConnection() throws SQLException{
	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/propertydb","i.angelinin","password");
	return conn;
	}
	
}
