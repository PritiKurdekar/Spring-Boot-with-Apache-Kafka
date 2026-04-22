package com.example.account_service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.account_service.dto.Transaction;
import com.example.account_service.service.AccountService;



@Service
public class TransactionConsumer {
	 @Autowired
	    private AccountService accountService;

	    @KafkaListener(topics = "bank-topic", groupId = "account-group")
	    public void consume(Transaction txn) {
	    	Transaction tx1=new Transaction();
	    	tx1.setAmount(txn.getAmount());
	    	tx1.setFromAccount(txn.getFromAccount());
	    	tx1.setToAccount(txn.getToAccount());
	    	tx1.setTransactionId(txn.getTransactionId());
	    	
	        System.out.println("Received from Kafka: " + txn);

	        accountService.updateBalance(txn);
	    }
}
