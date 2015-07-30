package db;

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

}
