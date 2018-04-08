package com.clip.app;

import com.clip.model.Constants;
import com.clip.transaction.TransactionService;
import com.google.gson.Gson;
import com.google.inject.Inject;

public class RequestProcessorImpl implements RequestProcessor {
	@Inject
	TransactionService transactionSvc;

	@Inject
	Gson gson;

	public void processRequest(String[] args) {

		String verb = args[1];

		switch (verb) {
		case Constants.ADD_TRANSACTION:
			transactionSvc.addTransaction(args);
			break;
		case Constants.SHOW_TRANSACTION:
			transactionSvc.showTransaction(args);
			break;
		case Constants.LIST_TRANSACTION:
			transactionSvc.listTransactions(args);
			break;
		case Constants.SUM_TRANSACTIONS:
			transactionSvc.sumTransactions(args);
			break;
		default:
			break;
		}

	}
}