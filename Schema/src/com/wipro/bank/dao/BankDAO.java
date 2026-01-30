package com.wipro.bank.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.util.DBUtil;

public class BankDAO {
	public int generateSequenceNumber() {
		Connection connection=DBUtil.getDBConnection();
		String query="SELECT transcationID_seq1.NEXTVAL from dual";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int seqNumber=rs.getInt(1);
			return seqNumber;
	}catch(Exception e) {
			e.printStackTrace();
			return 0;
	}
	}
	public boolean validateAccount(String accountNumber) {
		boolean isValid=false;
		try {
		Connection connection=DBUtil.getDBConnection();
		String query="SELECT Account_Number FROM ACCOUNT_TBL1 WHERE Account_Number=?";
		PreparedStatement ps=connection.prepareStatement(query);
		ps.setString(1, accountNumber);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			return true;
		}
		return false;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}
		public float findBalance(String accountNumber) {
			if(validateAccount(accountNumber)) {
		        Connection connection = DBUtil.getDBConnection();
		        String query = "SELECT Balance FROM ACCOUNT_TBL1 WHERE Account_Number = ?";
		    try {
		        
		        PreparedStatement ps = connection.prepareStatement(query);
		        ps.setString(1, accountNumber);
		        ResultSet rs=ps.executeQuery();
		        rs.next() ;
				float balance = rs.getFloat(1);
		        return balance;
		    } catch (Exception e) {
		        e.printStackTrace();
		        
		    }
		    
		
	}
			 return -1;
}

		public boolean updateBalance(String accountNumber,float newBalance) {
			try {
		        Connection connection = DBUtil.getDBConnection();
		        String query = "UPDATE ACCOUNT_TBL1 SET Balance=? WHERE Account_Number = ?";
		        PreparedStatement ps = connection.prepareStatement(query);
		        ps.setFloat(1, newBalance);
		        ps.setString(2, accountNumber);

		        boolean result = ps.execute(); 
		        return true;

		    } catch (Exception e) {
		        e.printStackTrace();
		        return false;
		        
}
}
		public boolean transferMoney(TransferBean transferBean) {
			transferBean.setTranscationID(generateSequenceNumber());
			Connection connection = DBUtil.getDBConnection();
	        String query = "INSERT INTO TRANSFER_TBL values(?,?,?,?,?)";
	        try {
	        PreparedStatement ps = connection.prepareStatement(query);
	        ps.setInt(1,transferBean.getTranscationID());
	        ps.setString(2, transferBean.getFromAccountNumber());
	        ps.setString(3, transferBean.getToAccountNumber() );
	        Date d=new Date(transferBean.getDateOFTranscation().getTime());
	        ps.setDate(4,d);
	        ps.setFloat(5,transferBean.getAmount());
	        int rows=ps.executeUpdate();
	        if (rows>0) {
	        	return true;
	        }
	        
	       } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return false;
		}
}
