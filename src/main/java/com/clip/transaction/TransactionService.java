package com.clip.transaction;

import java.util.List;

import com.clip.model.Transaction;

interface TransactionService {
    Transaction addTransaction();

    Transaction showTransaction();

    List<Transaction> listTransactions();

    String sumTransactions(); 
}