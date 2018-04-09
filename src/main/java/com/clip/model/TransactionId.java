package com.clip.model;

public class TransactionId {

	private String transactionId;
	
	public TransactionId(String transactionId){
		this.transactionId = transactionId;
	}
	
	public String getValue(){
		return this.transactionId;
	}
}
