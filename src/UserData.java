
public class UserData {
	private Property[] properties;
	private Payment[] payments;
	public UserData (Property[] properties,Payment[] payments){
		this.payments = payments;
		this.properties = properties;
	}
	public Property[] getProperties(){
		return this.properties;
	}
	public Payment[] getPayments(){
		return this.payments;
	}
	public void setProperties(Property[] properties){
		this.properties = properties;
	}
	public void setPayments(Payment[] payments){
		this.payments = payments;
	}
}
