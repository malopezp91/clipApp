package com.clip.model;

import java.util.Date;

public class Transaction{
    private double amount;
    private String description;
    private Date date;
    private UserId userId;
    
    public Transaction(){
    	super();
    }
    
    public Transaction withAmount(double amount){
    	this.amount = amount;
    	return this;
    }
    
 
}