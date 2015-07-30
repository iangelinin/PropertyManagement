package entities;

public class Payment {
	private Integer id;
	private int propertyId;
	private String date;
	private String comment;
	private double amount;
	private String payer;
	private int rentsId;
	
	public Payment (){
		
	}
	public int getPropertyId(){
		return this.propertyId;
	}
	public String getDate(){
		return this.date;
	}
	public double getAmount(){
		return this.amount;
	}
	public String getComment(){
		return this.comment;
	}
	public String getPayer(){
		return this.payer;
	}
	public void setPropertyId(int id){
		this.propertyId = id;
	}
	public void setDate(String date){
		this.date = date;
	}
	public void setAmount(double amount){
		this.amount = amount;
	}
	public void setComment(String comment){
		this.comment = comment;
	}
	public void setPayer(String payer){
		this.payer = payer;
	}
	public int getRentsId() {
		return rentsId;
	}
	public void setRentsId(int rentsId) {
		this.rentsId = rentsId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
