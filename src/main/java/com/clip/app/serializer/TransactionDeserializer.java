package com.clip.app.serializer;

import java.lang.reflect.Type;
import java.util.Date;

import com.clip.model.Transaction;
import com.clip.model.UserId;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class TransactionDeserializer implements JsonDeserializer<Transaction>{

	@Override
	public Transaction deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		
		JsonObject jsonElem = json.getAsJsonObject();
		
		String transactionId = jsonElem.get("transaction_id").getAsString();
		double amount  = jsonElem.get("amount").getAsDouble();
		String description = jsonElem.get("description").getAsString();
		String date = jsonElem.get("date").getAsString();
		UserId userId = new UserId(jsonElem.get("user_id").getAsString());
		
		Transaction transaction = new Transaction();
		transaction.withTransactionId(transactionId).withAmount(amount).withDescription(description).withDate(new Date()).withUserId(userId);
		
		return transaction;
	}

}
