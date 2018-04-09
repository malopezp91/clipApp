package com.clip.model;

public class TransactionSummatory {
	private UserId userId;
	
	private double summatory;
	
	public TransactionSummatory(){
		super();
	}
	
	public TransactionSummatory withUserId(UserId userId){
		this.userId = userId;
		return this;
	}
	
	public TransactionSummatory withSumatoryValue(double sumatory){
		this.summatory = sumatory;
		return this;
	}
	
	public UserId getUserId(){
		return this.userId;
	}
	
	public double getSummatory(){
		return this.summatory;
	}
}
