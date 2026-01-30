package com.wipro.bank.bean;
import java.util.Date;

public class TransferBean {
	private int transcationID;
	private String fromAccountNumber;
	private String toAccountNumber;
	private Date dateOFTranscation;
	private float amount;
	
	public TransferBean() {
		this.transcationID=transcationID;
		this.fromAccountNumber=fromAccountNumber;
		this.toAccountNumber=toAccountNumber;
		this.dateOFTranscation=dateOFTranscation;
		this.amount=amount;
	}
	public int getTranscationID() {
		return transcationID;
	}
	public void setTranscationID(int transcationID) {
		this.transcationID = transcationID;
	}
	public String getFromAccountNumber() {
		return fromAccountNumber;
	}
	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}
	public String getToAccountNumber() {
		return toAccountNumber;
	}
	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}
	public Date getDateOFTranscation() {
		return dateOFTranscation;
	}
	public void setDateOFTranscation(Date dateOFTranscation) {
		this.dateOFTranscation = dateOFTranscation;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}

}

