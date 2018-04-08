package com.clip.app.serializer;

import java.lang.reflect.Type;

import com.clip.model.Transaction;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class TransactionSerializer implements JsonSerializer<Transaction>{

	@Override
	public JsonElement serialize(Transaction src, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject json = new JsonObject();
		
		json.addProperty("transaction_id", src.getTransactionId());
		json.addProperty("amount", src.getAmount());
		json.addProperty("description", src.getDescription());
		json.addProperty("date", src.getDate().toString());
		json.addProperty("user_id", src.getUserId().getValue());
		
		return json;
	}
	

}
