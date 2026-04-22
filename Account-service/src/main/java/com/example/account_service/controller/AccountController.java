package com.example.account_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.account_service.dto.Transaction;
import com.example.account_service.service.AccountService;

@RestController
@RequestMapping("/accounts")

public class AccountController {
	@Autowired
    private AccountService service;

    @PostMapping("/update")
    public String update(@RequestBody Transaction txn) {
        return service.updateBalance(txn);
    }
}
