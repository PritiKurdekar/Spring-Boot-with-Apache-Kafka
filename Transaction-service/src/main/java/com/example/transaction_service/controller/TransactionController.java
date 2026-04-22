package com.example.transaction_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.transaction_service.model.Transaction;
import com.example.transaction_service.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	@Autowired
    private TransactionService service;

    @PostMapping
    public String transfer(@RequestBody Transaction txn) {
        return service.processTransaction(txn);
    }

}
