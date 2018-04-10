# Clip BackEnd Exercise

This JVM Application allows to persist and retrieve transactions. In this implementation, transactions are saved in disk, using a folder structure as follows:

transactions/userId/transactionId.json

## Unit Tests
Unit Tests can be executed using the following command:
```bash
mvn clean test
```

## Create distributable JAR
The  distributable JAR file can be created using the following command:
```bash
mvn clean package
```

This JAR file is located in the target folder.

## Execution Scenarios
Once the JAR file is created, you can execute the following functionalities.

 - Add Transaction

The following command will add a new transaction for the given userId. All transactions can be found in the folder *transactions*. Inside the *transaction* folder, new folders named by the *userId* will contain each one of the transactions files. The *transactions files* are named after the *transactionId* assigned before saving each one of them.
```bash
java -jar target\backend-test-app-1.0-SNAPSHOT.jar <user-id> add "transaction-json"
```
Example:
```bash
java -jar target\backend-test-app-1.0-SNAPSHOT.jar 3333-33-6 add "{\"amount\":56.6,\"description\":\"This is a new transaction\",\"date\":\"2018-04-09\",\"user_id\":\"3333-33-6\"}"
```
Output:
```
RESULT: {"transaction_id":"0ff34db9-8db4-49f8-aba5-0e854f6f283a","amount":56.6,"description":"This is a new transaction","date":"2018-04-09","user_id":"3333-33-6"}
```

 - Show Transaction
The following command will display the transaction given the transactionId and userId. If the file is not found, an error message is displayed.
```bash
java -jar target\backend-test-app-1.0-SNAPSHOT.jar <user-id> <transaction-id>
```
Example:
```bash
java -jar target\backend-test-app-1.0-SNAPSHOT.jar 3333-33-6 0ef11502-962e-496f-95af-8cba45667c27
```
Output:
```
RESULT: {"transaction_id":"b07218bc-478a-4cb9-904a-5c1b89347dee","amount":56.6,"description":"This is another transaction","date":"2018-04-08","user_id":"3333-33-6"}
```  
 - List Transactions
The following command will display all transactions given the userId. Transactions are sorted by date, being the first item in the array the most recent transaction. If there are no transactions, an empty array is displayed.
```bash
java -jar target\backend-test-app-1.0-SNAPSHOT.jar <user-id> list
```
Example:
```bash
java -jar target\backend-test-app-1.0-SNAPSHOT.jar 3333-33-6 list
```
Output:
```
RESULT: [{"transaction_id":"0c233ebb-e293-40a9-845a-60e3c1805058","amount":45.8,"description":"This is even a new transaction","date":"2018-04-09","user_id":"3333-33-6"},{"transaction_id":"0ff34db9-8db4-49f8-aba5-0e854f6f283a","amount":56.6,"description":"This is a new transaction","date":"2018-04-09","user_id":"3333-33-6"},{"transaction_id":"6c5840d6-c721-4dff-be7d-18978cb8d1c0","amount":56.6,"description":"This is a new transaction","date":"2018-04-09","user_id":"3333-33-6"},{"transaction_id":"b07218bc-478a-4cb9-904a-5c1b89347dee","amount":56.6,"description":"This is another transaction","date":"2018-04-08","user_id":"3333-33-6"},{"transaction_id":"a463efd1-fb3b-496e-99a1-44b523b5f82d","amount":34.4,"description":"The not so old trans","date":"2018-03-20","user_id":"3333-33-6"},{"transaction_id":"4f3a6af3-4cb8-4059-8283-3240d0fad169","amount":70.8,"description":"This is an oooold transacion","date":"2017-01-09","user_id":"3333-33-6"}]
```

 - Sum Transactions
The following command will sum the amount values for all transactions given a userId. 
```bash
java -jar target\backend-test-app-1.0-SNAPSHOT.jar <user-id> sum
```
Example:
```bash
java -jar target\backend-test-app-1.0-SNAPSHOT.jar 3333-33-6 sum
```
Output:
```
RESULT{"userId":"3333-33-6","sum":320.8}
```

## Changing Data Access Layer Implementation

If instead of persisting the transaction data into the disk we decide to use a No-SQL DB, it can be easily implemented by following the next steps:
1. Create a class that implements the interface *TransactionPersistance*. This interface have the following methods:
		- saveTransaction
		- getTransactionByUserId
		- getAllTransactionsByUserId
		
2. If using MongoDb, all transaction data can be allocated in a collections called: *Transactions*. The transaction JSON data will be persisted into that collection. Both getTransactionByUserId and getAllTransactionsByUserId are easier to implement using a MongoDb driver/mapper rather than the read-file and look-for-files logic used in this exercise.
 
