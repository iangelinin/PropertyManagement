package db;

import java.sql.ResultSet;
import java.sql.SQLException;

import entities.*;

import java.util.ArrayList;

public class PaymentManager extends BaseManager{

	public PaymentManager() throws ClassNotFoundException, SQLException {
		super();
	}
	public ArrayList<Payment> getPayments() throws SQLException {
		try{
		ResultSet rs = super.stmt.executeQuery("SELECT R.property_id, P.date , P.amount, P.comment, P.payer FROM payments P, rents R"
				+ " WHERE R.id_rents = P.rents_id");
		
		ArrayList<Payment> payments = new ArrayList<Payment>();
		
		
		//Filling the ArrayList
				rs.beforeFirst();
				while(rs.next()){ 
					Payment payment = new Payment();
					//Filling the Payment
					payment.setPropertyId(rs.getInt(1));
					payment.setDate(rs.getDate(2).toString());
					payment.setAmount(rs.getDouble(3));
					payment.setComment(rs.getString(4));
					payment.setPayer(rs.getString(5));
					
					//Adding to the ArrayList
					payments.add(payment);
					payment = null;
				}
		
		rs = null;
		return payments;}
		finally{
			super.conn.close();
		}
		
	}

}
