package com.example.backend.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.example.backend.model.Transaction;
import com.example.backend.service.TransactionService;
import com.example.backend.utils.UtilityService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.web.bind.annotation.*;

import com.example.backend.repository.TransactionRepository;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;

@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController {

    private  final TransactionRepository repository;
    private final UtilityService utilityService;
    private final TransactionService service;

    @GetMapping("/all")
    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    @GetMapping("/getByTags")
    public List<Transaction> getExpensesForTags(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        HashMap<String, Integer> responseMap = new HashMap<>();
//        System.out.println(repository.findByTag());
//        return repository.findByTag();
        return service.getExpensesForTagsByDates();
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



