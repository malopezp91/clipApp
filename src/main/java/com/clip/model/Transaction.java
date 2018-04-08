package com.clip.model;

import java.util.Date;

public class Transaction{
	
	private String transactionId;
    private double amount;
    private String description;
    private Date date;
    private UserId userId;
    
    public Transaction(){
    	super();
    }
    public Transaction withTransactionId(String transactionId){
    	this.transactionId = transactionId;
    	return this;
    }
    
    public Transaction withAmount(double amount){
    	this.amount = amount;
    	return this;
    }
    
    public Transaction withDescription(String description){
    	this.description = description;
    	return this;
    }
    
    public Transaction withDate(Date date){
    	this.date = date;
    	return this;
    }
    
    public Transaction withUserId(UserId userId){
    	this.userId = userId;
    	return this;
    }
    
    public String getTransactionId(){
    	return this.transactionId;
    }
    
    public double getAmount(){
    	return this.amount;
    }
    
    public String getDescription(){
    	return this.description;
    }
    
    public Date getDate(){
    	return this.date;
    }
    
    public UserId getUserId(){
    	return this.userId;
    }
}