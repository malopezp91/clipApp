package com.clip.transaction;

import java.util.List;
import java.util.UUID;

import com.clip.app.persistance.TransactionPersistance;
import com.clip.model.Transaction;
import com.clip.model.TransactionId;
import com.clip.model.TransactionSummatory;
import com.clip.model.UserId;
import com.google.gson.Gson;
import com.google.inject.Inject;

public class TransactionServiceImpl implements TransactionService {

	@Inject
	TransactionPersistance transactionPersistance;

	@Inject
	Gson gson;

	@Override
	public Transaction addTransaction(String[] args) {
		// Deserialize JSON input for transaction
		UserId userId = new UserId(args[0]);
		Transaction transaction = gson.fromJson(args[2], Transaction.class);

		transaction.withTransactionId(new TransactionId(UUID.randomUUID().toString()));

		return transactionPersistance.saveTransaction(userId, transaction);

	}

	@Override
	public Transaction showTransaction(String[] args) {
		UserId userId = new UserId(args[0]);
		TransactionId transactionId = new TransactionId(args[2]);

		return transactionPersistance.getTransactionByUserId(userId, transactionId);
	}

	@Override
	public List<Transaction> listTransactions(String[] args) {
		UserId userId = new UserId(args[0]);

		return transactionPersistance.getAllTransactionsByUserId(userId);
	}

	@Override
	public TransactionSummatory sumTransactions(String[] args) {
		UserId userId = new UserId(args[0]);
		
		List<Transaction> transactions = transactionPersistance.getAllTransactionsByUserId(userId);
		
		double sum =  transactions.stream().map((t) -> t.getAmount()).reduce(0.0, (x, y) -> x+y);
		
		TransactionSummatory transactionSum = new TransactionSummatory();
		transactionSum.withSumatoryValue(sum).withUserId(userId);
		
		return transactionSum;
	}

}
