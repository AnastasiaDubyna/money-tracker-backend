package com.example.backend.controller;


import java.util.List;

import com.example.backend.model.Transaction;
import com.example.backend.utils.UtilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.example.backend.repository.TransactionRepository;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController {

    private  final TransactionRepository repository;
    private final UtilityService utilityService;

    @GetMapping("/all")
    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    @PostMapping("/file/upload")
    public String importTransactions(@RequestParam("file")MultipartFile file) {
        System.out.print(file);
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



