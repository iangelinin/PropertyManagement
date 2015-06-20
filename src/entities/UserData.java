package entities;
import java.util.ArrayList;

public class UserData {
	private ArrayList<Property> properties;
	private ArrayList<Payment> payments;
	public UserData (ArrayList<Property> properties,ArrayList<Payment> payments){
		this.payments = payments;
		this.properties = properties;
	}
	public ArrayList<Property> getProperties(){
		return this.properties;
	}
	public ArrayList<Payment> getPayments(){
		return this.payments;
	}
	public void setProperties(ArrayList<Property> properties){
		this.properties = properties;
	}
	public void setPayments(ArrayList<Payment> payments){
		this.payments = payments;
	}
}
