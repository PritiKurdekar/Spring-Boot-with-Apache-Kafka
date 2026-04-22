package com.example.transaction_service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.transaction_service.model.Transaction;

@Service
public class TransactionProducer {
	@Autowired
    private KafkaTemplate<String, Transaction> kafkaTemplate;

    private static final String TOPIC = "bank-topic";

    public void sendTransaction(Transaction txn) {
        kafkaTemplate.send(TOPIC, txn);
        System.out.println("Sent to Kafka: " + txn);
    }

}
