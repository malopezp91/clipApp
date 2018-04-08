package com.clip.transaction;

import java.util.List;

import com.clip.app.persistance.TransactionPersistance;
import com.clip.model.Transaction;
import com.google.gson.Gson;
import com.google.inject.Inject;

public class TransactionServiceImpl implements TransactionService{

	@Inject
	TransactionPersistance transactionPersistance;
	
	@Inject
	Gson gson;
	
	@Override
	public Transaction addTransaction(String[] args) {
		//Deserialize JSON input for transaction
		Transaction transactionToPersist = gson.fromJson(args[2], Transaction.class);		
		
		transactionPersistance.saveTransaction(null);
		
		return null;
	}

	@Override
	public Transaction showTransaction(String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> listTransactions(String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sumTransactions(String[] args) {
		// TODO Auto-generated method stub
		return null;
	}



}
