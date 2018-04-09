package com.clip.app.persistance;

import java.util.List;

import com.clip.model.Transaction;
import com.clip.model.TransactionId;
import com.clip.model.UserId;

public interface TransactionPersistance {
	Transaction saveTransaction(UserId userId, Transaction transaction);
	
	Transaction getTransactionByUserId(UserId userId, TransactionId transactionId);
	
	List<Transaction> getAllTransactionsByUserId(UserId userId);
	
}
