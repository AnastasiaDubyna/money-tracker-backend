package com.example.backend.controller;

import java.util.List;

import com.example.backend.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.backend.repository.TransactionRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController {
    @Autowired
    private TransactionRepository repository;

    @GetMapping("/")
    public String getAllTransactions() {
        System.out.println("Get  request received");
        System.out.println(repository.findAll());
        return "transactions";
    }

    @PostMapping("file/upload")
    public String importTransactions(@RequestParam("file") List<Transaction> transactions) {
        System.out.print(transactions);
        // repository.saveAll(transactions);
        return "imported";
    }

    @PostMapping("/add")
    public String addNewTransaction(@RequestBody Transaction transaction) {
        System.out.println("REQUEST RECEIVED");
        repository.save(transaction);
        return "transaction added";
    }

}



