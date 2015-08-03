package entities;

public class NewProperty {
	private Tenant tenant;
	private Property property;
	private int rentsId;
	public Tenant getTenant() {
		return tenant;
	}
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	public int getRentsId() {
		return rentsId;
	}
	public void setRentsId(int rentsId) {
		this.rentsId = rentsId;
	}
	

}
