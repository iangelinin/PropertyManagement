package db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginManager extends BaseManager{
	public LoginManager() throws ClassNotFoundException, SQLException {
		super();
	}
	public int checkUser(String email, String password) throws SQLException{
		try{
			ResultSet rs = stmt.executeQuery("SELECT U.idusers FROM users U WHERE U.user_email = \'"+email+"\' AND u.user_password = \'"+ password +"\';");
			try{		
					rs.first();
					int id = rs.getInt(1);
					return id;
				}
			catch(Exception e ){
				return -1;
			}
		}
		finally{
			conn.close();
		}
	}

}
