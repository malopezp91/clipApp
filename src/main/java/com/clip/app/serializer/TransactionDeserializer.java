package com.clip.app.serializer;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Date;

import com.clip.model.Transaction;
import com.clip.model.TransactionId;
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
		
		String transactionId = jsonElem.has("transaction_id") ? jsonElem.get("transaction_id").getAsString() : "";
		double amount  = jsonElem.get("amount").getAsDouble();
		String description = jsonElem.get("description").getAsString();
		String date = jsonElem.get("date").getAsString();
		String userId = jsonElem.get("user_id").getAsString();
		
		Transaction transaction = new Transaction();
		transaction.withTransactionId(new TransactionId(transactionId)).withAmount(amount).withDescription(description).withDate(LocalDate.parse(date)).withUserId(new UserId(userId));
		
		return transaction;
	}

}
