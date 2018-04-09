package com.clip.app;

import java.util.Arrays;
import java.util.List;

import com.clip.model.Constants;
import com.clip.model.Transaction;
import com.clip.model.TransactionSummatory;
import com.clip.transaction.TransactionService;
import com.google.gson.Gson;
import com.google.inject.Inject;

public class RequestProcessorImpl implements RequestProcessor {
	@Inject
	TransactionService transactionSvc;

	@Inject
	Gson gson;

	public void processRequest(String[] args) {
		
		//Add validation to input!
		
		String verb = args[1];

		switch (verb) {
		case Constants.ADD_TRANSACTION:
			try{
				System.out.println("RESULT: " + gson.toJson(transactionSvc.addTransaction(args)));
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case Constants.SHOW_TRANSACTION:
			try {
				System.out.println("RESULT: " + gson.toJson(transactionSvc.showTransaction(args)));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case Constants.LIST_TRANSACTION:
			try{
				List<Transaction> aaa = transactionSvc.listTransactions(args);
				System.out.println("RESULT: " + gson.toJson(aaa));
			} catch (Exception e) {
				System.out.println(e);
			}
			break;
		case Constants.SUM_TRANSACTIONS:
			try {
				System.out.println("RESULT" + gson.toJson(transactionSvc.sumTransactions(args)));
			} catch (Exception e) {
				System.out.println(e);
			}

			break;
		default:
			break;
		}

	}
}