package db;

import java.sql.ResultSet;
import java.sql.SQLException;

import entities.*;

import java.util.ArrayList;
	
	public class PropertyManager extends BaseManager {
		
		public PropertyManager() throws ClassNotFoundException, SQLException{
	
			super();
}
	public ArrayList<Property> getProperties(int id) throws SQLException{
		try{
		ResultSet rs = super.stmt.executeQuery("SELECT P.id_property, P.property_name, P.address, P.rent, T.tenant_name, T.telephone, T.email,R.id_rents,T.id_tenant "
				+ "FROM property P, tenant T, rents R "
				+ "WHERE R.property_id=P.id_property AND R.tenant_id = T.id_tenant AND R.user_id = "+id+";");
		
		ArrayList<Property> properties = new ArrayList<Property>();
		
		
		//Filling the ArrayList
		rs.beforeFirst();
		while(rs.next()){ 
			Property prop = new Property();
			Tenant tenant = new Tenant();			
			
			//Filling the Tenant Object
			tenant.setName(rs.getString(5));
			tenant.setPhone(rs.getString(6));
			tenant.setEmail(rs.getString(7));
			tenant.setId(rs.getInt(9));
		
			//Filling the Property Object
			prop.setPropertyId(rs.getInt(1));
			prop.setPropertyName(rs.getString(2));
			prop.setAddress(rs.getString(3));
			prop.setRent(rs.getDouble(4));
			prop.setRentsId(rs.getInt(8));
			prop.setTenant(tenant);
			
			//Adding the property to the ArrayList
			properties.add(prop);	
			
			prop = null;
			tenant = null;
		}
		
		
		rs = null;
		
		return properties;}
		finally{
			super.conn.close();
		}
	}
		public void updateProperty(Property property) throws SQLException{
			try{
				super.stmt.executeUpdate("UPDATE property SET property_name=\'"+property.getPropertyName()+"\',address=\'"+property.getAddress()+"\',rent=\'"+property.getRent()+"\'"+"  WHERE id_property=\'"+property.getPropertyId()+"\';");
			}
			finally {
			conn.close();
			}
		}
		public Property insertProperty(Property property) throws SQLException{
			try{
				super.stmt.executeUpdate("INSERT INTO property  (property_name,address,rent) VALUES (\'"+property.getPropertyName()+"\',\'"+property.getAddress()+"\',"+property.getRent()+");");
				ResultSet rs = super.stmt.executeQuery("select last_insert_id() as last_id from property");
				rs.next();
				property.setPropertyId(rs.getInt(1));
				return property;
			}
			finally {
			conn.close();
		
			}
			
		}
	
	


}
