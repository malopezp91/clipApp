package com.clip.transaction;

import java.util.Comparator;

import com.clip.model.Transaction;

public class TransactionComparatorByLocalDate implements Comparator<Transaction> {

	@Override
	public int compare(Transaction o1, Transaction o2) {
		if (o1.getDate().isAfter(o2.getDate())) {
			return -1;
		} else if (o2.getDate().isAfter(o1.getDate())) {
			return 1;
		} else {
			return 0;
		}
	}

}
