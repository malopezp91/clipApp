package com.clip.app.persistance;

import java.util.List;

import com.clip.model.Transaction;
import com.clip.model.UserId;

public interface TransactionPersistance {
	Transaction saveTransaction(Transaction transaction);
	
	Transaction getTransactionByUserId(UserId userId);
	
	List<Transaction> getAllTransactionsByUserId(UserId userId);
	
}
