package com.example.backend.controller;

import java.util.List;

import com.example.backend.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.backend.repository.TransactionRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class TransactionController {
    @Autowired
    private TransactionRepository repository;

    @PostMapping("file/upload")
    public String importTransactions(@RequestParam("file") List<Transaction> transactions) {
        System.out.print(transactions);
        // repository.saveAll(transactions);
        return "imported";
    }

    @PostMapping("transaction/add")
    public String addNewTransaction(@RequestBody Transaction transaction) {
        repository.save(transaction);
        return "transaction added";
    }

}



