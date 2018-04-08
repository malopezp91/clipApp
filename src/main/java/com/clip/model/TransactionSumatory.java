package com.clip.model;

public class TransactionSumatory {
	private UserId userId;
	
	private double sumatory;
	
	public TransactionSumatory(){
		super();
	}
	
	public TransactionSumatory withUserId(UserId userId){
		this.userId = userId;
		return this;
	}
	
	public TransactionSumatory withSumatoryValue(double sumatory){
		this.sumatory = sumatory;
		return this;
	}
	
	public UserId getUserId(){
		return this.userId;
	}
	
	public double sumatory(){
		return this.sumatory;
	}
}
