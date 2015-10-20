package db;

import java.sql.ResultSet;
import java.sql.SQLException;

import entities.*;

import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class PaymentManager extends BaseManager{

	public PaymentManager() throws ClassNotFoundException, SQLException {
		super();
	}
	public ArrayList<Payment> getPayments(int id) throws SQLException {
		try{
		ResultSet rs = super.stmt.executeQuery("SELECT R.property_id, P.date , P.amount, P.comment, P.payer, R.id_rents, P.id_payments FROM payments P, rents R"
				+ " WHERE R.id_rents = P.rents_id AND R.user_id = "+id+";");
		
		ArrayList<Payment> payments = new ArrayList<Payment>();
		
		
		//Filling the ArrayList
				rs.beforeFirst();
				while(rs.next()){ 
					Payment payment = new Payment();
					//Filling the Payment
					payment.setId(rs.getInt(7));
					payment.setPropertyId(rs.getInt(1));
					payment.setDate(rs.getDate(2).toString());
					payment.setAmount(rs.getDouble(3));
					payment.setComment(rs.getString(4));
					payment.setPayer(rs.getString(5));
					payment.setRentsId(rs.getInt(6));
					
					//Adding to the ArrayList
					payments.add(payment);
					payment = null;
				}
		
		rs = null;
		return payments;}
		finally{
			conn.close();
		}
		
	}
	public int insertPayments(Payment payment) throws SQLException{
		try{
			int id = super.stmt.executeUpdate("INSERT INTO payments  (rents_id,date,amount,comment,"
					+"payer) VALUES ("+payment.getRentsId()+",\'"+payment.getDate()+"\',"+payment.getAmount()+",\'"+payment.getComment()+"\',\'"+payment.getPayer()+"\');");
			ResultSet rs = super.stmt.executeQuery("select last_insert_id() as last_id from payments");
			rs.next();
			id = rs.getInt(1);
			return id;
		}
		finally {
		conn.close();
	
		}
		
	}
	public void updatePayment(Payment payment) throws SQLException{
		try{
			super.stmt.executeUpdate("UPDATE payments SET rents_id=\'"+payment.getRentsId()+"\',date=\'"+payment.getDate()+"\',amount=\'"+payment.getAmount()+"\',comment=\'"+payment.getComment()+"\',"+
					"payer=\'"+payment.getPayer()+"\' WHERE id_payments=\'"+payment.getId()+"\';");
		}
		finally {
		conn.close();
		}
	}
	public void deletePayment(String id) throws SQLException{
		try{
			super.stmt.executeUpdate("DELETE FROM payments  WHERE id_payments=\'"+id+"\';");
		}
		finally {
		conn.close();
		}
	}
}
