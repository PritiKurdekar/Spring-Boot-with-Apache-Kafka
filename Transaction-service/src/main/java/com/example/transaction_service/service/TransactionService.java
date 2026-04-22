package com.example.transaction_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.transaction_service.kafka.TransactionProducer;
import com.example.transaction_service.model.Transaction;

@Service
public class TransactionService {
	@Autowired
	private TransactionProducer producer;

	public String processTransaction(Transaction txn) {
	    producer.sendTransaction(txn);
	    return "Transaction sent to Kafka";
	}
}
