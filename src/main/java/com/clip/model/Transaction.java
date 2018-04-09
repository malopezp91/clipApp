package com.clip.model;

import java.time.LocalDate;

public class Transaction{
	
	private TransactionId transactionId;
    private double amount;
    private String description;
    private LocalDate date;
    private UserId userId;
    
    public Transaction(){
    	super();
    }
    public Transaction withTransactionId(TransactionId transactionId){
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
    
    public Transaction withDate(LocalDate date){
    	this.date = date;
    	return this;
    }
    
    public Transaction withUserId(UserId userId){
    	this.userId = userId;
    	return this;
    }
    
    public TransactionId getTransactionId(){
    	return this.transactionId;
    }
    
    public double getAmount(){
    	return this.amount;
    }
    
    public String getDescription(){
    	return this.description;
    }
    
    public LocalDate getDate(){
    	return this.date;
    }
    
    public UserId getUserId(){
    	return this.userId;
    }
}