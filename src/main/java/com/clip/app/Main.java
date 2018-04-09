package com.clip.app;

import com.clip.app.persistance.TransactionPersistance;
import com.clip.app.persistance.TransactionPersistanceInFileSystemImpl;
import com.clip.app.serializer.TransactionDeserializer;
import com.clip.app.serializer.TransactionSerializer;
import com.clip.app.serializer.TransactionSummatorySerializer;
import com.clip.model.Transaction;
import com.clip.model.TransactionSummatory;
import com.clip.transaction.TransactionService;
import com.clip.transaction.TransactionServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;

//Guice Configuration Modules
class TransactionModule extends AbstractModule{

	@Override
	protected void configure() {
		//Bind all...
		bind(Gson.class).toProvider(SerializationProvider.class);
		bind(TransactionService.class).to(TransactionServiceImpl.class);
		bind(TransactionPersistance.class).to(TransactionPersistanceInFileSystemImpl.class);
	}
	
}

class SerializationProvider implements Provider<Gson>{

	@Override
	public Gson get() {
		GsonBuilder builder = new GsonBuilder();
		
		builder.registerTypeAdapter(Transaction.class, new TransactionDeserializer());
		builder.registerTypeAdapter(Transaction.class, new TransactionSerializer());
		builder.registerTypeAdapter(TransactionSummatory.class, new TransactionSummatorySerializer());
		
		return builder.create();
	}
	
}

public class Main 
{
    public static void main( String[] args )
    {
    	//We initialize Guice!
    	Injector injector = Guice.createInjector(new TransactionModule());
    	
    	//We create an instance of main processor and we pass the args!
    	injector.getInstance(RequestProcessorImpl.class).processRequest(args);
    }
}
