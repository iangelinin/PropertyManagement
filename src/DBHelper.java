import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class DBHelper {
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static Property[] getPropsFromDB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/propertydb","i.angelinin","password");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT P.id_property, P.property_name, P.address, P.rent, T.tenant_name, T.telephone, T.email FROM property P, tenant T, rents R WHERE R.property_id=P.id_property AND "
					+ "R.tenant_id = T.id_tenant;");
			rs.last();
			
			int size = rs.getRow();
			Property[] properties = new Property[size];
			rs.beforeFirst();
			int i = 0;
			while(rs.next()){
				properties[i] = new Property(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6),rs.getString(7));
				i++;
			}
			conn.close();
			
			return properties;
		}
		catch(Exception e) {
			System.out.println("Cannot connect to Data Base!");
			e.printStackTrace();
			return new Property[0];
		}
	}
	public static Payment[] getPaymentsFromDB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/propertydb","i.angelinin","password");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT R.property_id, P.date , P.amount, P.comment, P.payer FROM payments P, rents R WHERE R.id_rents = P.rents_id");
			rs.last();
			
			int size = rs.getRow();
			Payment[] payments = new Payment[size];
			rs.beforeFirst();
			int i = 0;
			while(rs.next()){
				payments[i] = new Payment(rs.getInt(1),rs.getDate(2).toString(),rs.getDouble(3),rs.getString(4),rs.getString(5));
				i++;
			}
			conn.close();
			
			return payments;
		}
		catch(Exception e) {
			System.out.println("Cannot connect to Data Base!");
			e.printStackTrace();
			return new Payment[0];
		}
	}
}