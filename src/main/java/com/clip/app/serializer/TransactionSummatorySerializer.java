package com.clip.app.serializer;

import java.lang.reflect.Type;

import com.clip.model.TransactionSummatory;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class TransactionSummatorySerializer implements JsonSerializer<TransactionSummatory>{

	@Override
	public JsonElement serialize(TransactionSummatory src, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject json = new JsonObject();
		
		json.addProperty("userId", src.getUserId().getValue());
		json.addProperty("sum", src.getSummatory());
		
		return json;
	}

}
