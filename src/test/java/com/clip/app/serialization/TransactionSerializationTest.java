package com.clip.app.serialization;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.clip.app.serializer.TransactionDeserializer;
import com.clip.app.serializer.TransactionSerializer;
import com.clip.model.Transaction;
import com.clip.model.TransactionId;
import com.clip.model.UserId;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TransactionSerializationTest {
	
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
		String expectedString = "{\"transaction_id\":\"123\",\"amount\":53.2,\"description\":\"This is a transaction\",\"date\":\"2018-04-07\",\"user_id\":\"user-id-123\"}"; 
		
		transaction.withAmount(53.2).withDate(LocalDate.parse("2018-04-07")).withDescription("This is a transaction").withTransactionId(new TransactionId("123")).withUserId(new UserId("user-id-123"));
		
		String asString = gson.toJson(transaction);
				
		assertNotNull(asString);
		assertEquals(expectedString, asString);
	}
	
	@Test
	public void fromJsonToObject(){
		String asString =  "{\"transaction_id\":\"123\",\"amount\":53.2,\"description\":\"This is a transaction\",\"date\":\"2018-04-07\",\"user_id\":\"user-id-123\"}";
		Transaction transaction = gson.fromJson(asString, Transaction.class);
		
		assertNotNull(transaction);
		assertEquals("123", transaction.getTransactionId().getValue());
		assertEquals(53.2, transaction.getAmount(), 0);
		assertEquals("This is a transaction", transaction.getDescription());
		assertEquals(LocalDate.parse("2018-04-07"), transaction.getDate());
		assertEquals("user-id-123", transaction.getUserId().getValue());
	}
	
	@Test
	public void fromJsonToObjectWithoutTransactionId(){
		String asString =  "{\"amount\":53.2,\"description\":\"This is a transaction\",\"date\":\"2018-04-07\",\"user_id\":\"user-id-123\"}";
		Transaction transaction = gson.fromJson(asString, Transaction.class);
		
		assertNotNull(transaction);
		assertEquals("", transaction.getTransactionId().getValue());
		assertEquals(53.2, transaction.getAmount(), 0);
		assertEquals("This is a transaction", transaction.getDescription());
		assertEquals(LocalDate.parse("2018-04-07"), transaction.getDate());
		assertEquals("user-id-123", transaction.getUserId().getValue());
	}
}
