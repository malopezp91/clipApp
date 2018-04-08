package com.clip.app.serialization;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.clip.app.serializer.TransactionDeserializer;
import com.clip.app.serializer.TransactionSerializer;
import com.clip.model.Transaction;
import com.clip.model.UserId;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TransactionSerialization {
	
	Gson gson;
	
	@Before
	public void setup(){
		GsonBuilder builder = new GsonBuilder();
		
		builder.registerTypeAdapter(Transaction.class, new TransactionDeserializer());
		builder.registerTypeAdapter(Transaction.class, new TransactionSerializer());
		
		gson =  builder.create();
	}
	
	@Test
	public void fromObjectToJson(){
		Transaction transaction = new Transaction();
		
		transaction.withAmount(53.2).withDate(new Date()).withDescription("This is a transaction").withTransactionId("123").withUserId(new UserId("user-id-123"));
		
		String asString  = gson.toJson(transaction);
		
		System.out.println(asString);
	}
}
