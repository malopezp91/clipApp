//package com.clip.app.transaction;
//
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.Spy;
//import org.mockito.junit.MockitoJUnit;
//import org.mockito.junit.MockitoRule;
//
//import com.clip.app.persistance.TransactionPersistance;
//import com.clip.transaction.TransactionServiceImpl;
//import com.google.gson.Gson;
//
//public class TransactionServiceTest {
//
//	@Rule
//	MockitoRule rule = MockitoJUnit.rule();
//
//	@InjectMocks
//	TransactionServiceImpl transactionSvc;
//	
//	@Mock
//	TransactionPersistance transactionPersistance;
//	
//	@Spy
//	Gson gson;
//	
//	@Before
//	public void setup(){
//		
//	}
//	
//	@Test
//	public void initialTest(){
//		Mockito.when(transactionPersistance.saveTransaction(null, null));
//		
//		
//		transactionSvc.addTransaction(null);
//	}
//	
//}
//	
