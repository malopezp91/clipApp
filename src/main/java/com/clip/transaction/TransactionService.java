package com.clip.transaction;

import java.util.List;

import com.clip.model.Transaction;
import com.clip.model.TransactionSummatory;

public interface TransactionService {
    Transaction addTransaction(String[]args);

    Transaction showTransaction(String[]args);

    List<Transaction> listTransactions(String[]args);

    TransactionSummatory sumTransactions(String[]args); 
}