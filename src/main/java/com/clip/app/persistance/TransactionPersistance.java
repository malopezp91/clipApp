package com.clip.app.persistance;

import java.util.List;

import com.clip.model.Transaction;

public interface TransactionPersistance {
	Transaction saveTransaction(Transaction transaction);
	
	Transaction getTransactionByUserId(String userId);
	
	List<Transaction> getAllTransactionsByUserId(String userId);
	
}
