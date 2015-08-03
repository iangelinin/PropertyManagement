package db;

import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Payment;
import entities.Tenant;

public class TenantManager extends BaseManager{
	public TenantManager() throws ClassNotFoundException, SQLException{
		
		super();
}
	public void updateTenant(Tenant tenant) throws SQLException{
		try{
			super.stmt.executeUpdate("UPDATE tenant SET id_tenant=\'"+tenant.getId()+"\',telephone=\'"+tenant.getPhone()+"\',tenant_name=\'"+tenant.getName()+"\',email=\'"+tenant.getEmail()+"\'"+"  WHERE id_tenant=\'"+tenant.getId()+"\';");
		}
		finally {
		conn.close();
		}
	}
	public Tenant insertTenant(Tenant tenant) throws SQLException{
		try{
			super.stmt.executeUpdate("INSERT INTO tenant  (tenant_name,telephone,email) VALUES (\'"+tenant.getName()+"\',"+tenant.getPhone()+",\'"+tenant.getEmail()+"\');");
			ResultSet rs = super.stmt.executeQuery("select last_insert_id() as last_id from tenant");
			rs.next();
			tenant.setId(rs.getInt(1));
			return tenant;
		}
		finally {
		conn.close();
	
		}
	}

}
