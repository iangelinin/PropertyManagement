package entities;

public class Property {
	private int propertyId;
	private String propertyName;
	private String address;
	private double rent;
	private int rentsId;
	private Tenant tenant;
	
	public Property (int propertyId,String propertyName,String address, double rent,String name, String phone, String email){
		this.propertyId = propertyId;
		this.propertyName = propertyName;
		this.address = address;
		this.rent = rent;
		
		
	}
	public Property(){}
	public int getPropertyId(){
		return this.propertyId;
	}
	public String getPropertyName(){
		return this.propertyName;
	}
	public String getAddress(){
		return this.address;
	}
	public double getRent(){
		return this.rent;
	}
	public void setPropertyId(int propertyId){
		this.propertyId = propertyId;
	}
	public void setPropertyName(String name){
		this.propertyName = name;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public void setRent(double rent){
		this.rent = rent;
	}
	public Tenant getTenant() {
		return tenant;
	}
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	public int getRentsId() {
		return rentsId;
	}
	public void setRentsId(int rentsId) {
		this.rentsId = rentsId;
	}
	
}
