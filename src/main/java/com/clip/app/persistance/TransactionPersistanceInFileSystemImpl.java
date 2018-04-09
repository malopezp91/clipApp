package com.clip.app.persistance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.clip.model.Transaction;
import com.clip.model.TransactionId;
import com.clip.model.UserId;
import com.clip.transaction.TransactionComparatorByLocalDate;
import com.google.gson.Gson;
import com.google.inject.Inject;

public class TransactionPersistanceInFileSystemImpl implements TransactionPersistance {

	private static final String TRANSACTON_DIRECTORY = "transactions";
	private static final String DIRECTORY_SEPARATOR = File.separator;
	private static final String FILE_EXTENSION = ".json";

	@Inject
	Gson gson;

	@Override
	public Transaction saveTransaction(UserId userId, Transaction transaction) {

		validateTransactionFolderExists();
		validateUserIdFolderExists(userId);

		try {
			String fileName = TRANSACTON_DIRECTORY + DIRECTORY_SEPARATOR + userId.getValue() + DIRECTORY_SEPARATOR
					+ transaction.getTransactionId().getValue() + FILE_EXTENSION;
			FileWriter fileWriter = new FileWriter(fileName);

			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(gson.toJson(transaction));

			bufferedWriter.close();

			return transaction;

		} catch (Exception e) {
			System.out.println("Error Writing file");
			System.out.println(e.getMessage());
			throw new RuntimeException("ERORR: TRANSACTION COULD NOT BE SAVED");
		}

	}

	@Override
	public Transaction getTransactionByUserId(UserId userId, TransactionId transactionId) {
		System.out.println("Retrieve transaction " + transactionId.getValue() + " for userId " + userId.getValue());

		if (!transactionFileExists(userId, transactionId)){
			throw new RuntimeException("ERROR: TRANSACTION NOT FOUND");
		}
		
		try {
			String fileName = TRANSACTON_DIRECTORY + DIRECTORY_SEPARATOR + userId.getValue() + DIRECTORY_SEPARATOR
					+ transactionId.getValue() + FILE_EXTENSION;

			Transaction transaction = readTransactionFile(new File(fileName));

			return transaction;
		} catch (Exception e) {
			throw new RuntimeException("ERROR: TRANSACTION COULD NOT BE RETRIEVED");
		}

	}

	@Override
	public List<Transaction> getAllTransactionsByUserId(UserId userId) {
		System.out.println("Retrieve all transactions for " + userId.getValue());

		List<Transaction> transactions = new ArrayList<>();
		
		if (!userFolderContainsTransactions(userId)){
			return transactions;
		}
		
		File userFolder = new File(TRANSACTON_DIRECTORY + DIRECTORY_SEPARATOR + userId.getValue());

		File[] listOfTransactions = userFolder.listFiles();

		Arrays.stream(listOfTransactions).forEach((fileName) -> {

			System.out.println(fileName);
			try {

				Transaction transaction = readTransactionFile(fileName);

				transactions.add(transaction);

			} catch (Exception e) {
				throw new RuntimeException("ERROR: TRANSACTIONS COULD NOT BEEN RETRIEVED");
			}

		});
		
		transactions.sort(new TransactionComparatorByLocalDate());
		
		return transactions;
	}

	private void validateTransactionFolderExists() {
		File baseDirectory = new File(TRANSACTON_DIRECTORY);

		if (!baseDirectory.exists()) {
			baseDirectory.mkdir();
		}

	}

	private void validateUserIdFolderExists(UserId userId) {
		File userDirectory = new File(TRANSACTON_DIRECTORY + DIRECTORY_SEPARATOR + userId.getValue());

		if (!userDirectory.exists()) {
			userDirectory.mkdir();
		}
	}
	
	private boolean transactionFileExists(UserId userId, TransactionId transactionId){
		File transactionFile = new File(TRANSACTON_DIRECTORY + DIRECTORY_SEPARATOR + userId.getValue() + DIRECTORY_SEPARATOR + transactionId.getValue() + FILE_EXTENSION);
		return transactionFile.exists();
	}
	
	private boolean userFolderContainsTransactions(UserId userId){
		File userDirectory = new File(TRANSACTON_DIRECTORY + DIRECTORY_SEPARATOR + userId.getValue());
		
		if (userDirectory.listFiles() == null){
			return false;
		}
		else return true;
	}

	private Transaction readTransactionFile(File file) throws IOException {

		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = "";
			String dataFromFile = "";

			while ((line = bufferedReader.readLine()) != null) {
				dataFromFile = dataFromFile + line;
			}

			bufferedReader.close();

			Transaction transaction = gson.fromJson(dataFromFile, Transaction.class);
			return transaction;
		} catch (Exception e) {
			throw new RuntimeException("ERROR: FILE COULD NOT BE READ");
		}

	}

}
