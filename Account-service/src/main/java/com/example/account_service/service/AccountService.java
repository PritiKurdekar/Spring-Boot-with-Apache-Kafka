package com.example.account_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.account_service.dto.Transaction;
import com.example.account_service.entity.Account;
import com.example.account_service.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository repo;

	public String updateBalance(Transaction txn) {

	        Account from = repo.findById(txn.getFromAccount()).orElseThrow();
	        Account to = repo.findById(txn.getToAccount()).orElseThrow();

	        if (from.getBalance() < txn.getAmount()) {
	            return "Insufficient Balance";
	        }

	        from.setBalance(from.getBalance() - txn.getAmount());
	        to.setBalance(to.getBalance() + txn.getAmount());

	        repo.save(from);
	        repo.save(to);

	        return "Transaction Successful";

}
	
}
