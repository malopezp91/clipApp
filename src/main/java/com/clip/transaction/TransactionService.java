package com.clip.transaction;

import java.util.List;

import com.clip.model.Transaction;

public interface TransactionService {
    Transaction addTransaction(String[]args);

    Transaction showTransaction(String[]args);

    List<Transaction> listTransactions(String[]args);

    String sumTransactions(String[]args); 
}