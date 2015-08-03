package db;

import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Property;
import entities.Tenant;

public class RentsManager extends BaseManager {
	public RentsManager() throws ClassNotFoundException, SQLException {
		super();
		
	}

	public int insertRents(Tenant tenant, Property property) throws SQLException{
		try{
			super.stmt.executeUpdate("INSERT INTO  rents (property_id,tenant_id) VALUES ("+property.getPropertyId()+","+tenant.getId()+");");
			ResultSet rs = super.stmt.executeQuery("select last_insert_id() as last_id from rents");
			rs.next();
			int id = rs.getInt(1);
			return id;
		}
		finally {
		conn.close();
	
		}
	}

}
