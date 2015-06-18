
public class Property {
	private Integer propertyId = null;
	private String propertyName = null;
	private String address = null;
	private Double rent = null;
	private String tenantName = null;
	private String phone = null;
	private String email = null;
	
	public Property (int propertyId,String propertyName,String address, double rent,String name, String phone, String email){
		this.propertyId = propertyId;
		this.propertyName = propertyName;
		this.address = address;
		this.rent = rent;
		this.tenantName = name;
		this.phone = phone;
		this.email = email;
	}
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
	}public String getTenantName(){
		return this.tenantName;		
	}
	public String getPhone(){
		return this.phone;
	}
	public String getEmail(){
		return this.email;
	}
	public void setTenantName(String name){
		this.tenantName = name;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public void setEmail(String email){
		this.email = email;
	}
	
}
