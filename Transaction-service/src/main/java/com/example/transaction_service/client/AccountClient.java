package com.example.transaction_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.transaction_service.model.Transaction;

@FeignClient(name = "account-service", url = "http://localhost:8081")
public interface AccountClient {
	@PostMapping("/accounts/update")
    String updateBalance(@RequestBody Transaction txn);
}
