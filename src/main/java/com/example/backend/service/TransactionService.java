package com.example.backend.service;

import com.example.backend.model.Transaction;
import com.example.backend.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;

@RequiredArgsConstructor
@Component
public class TransactionService {

    private  final TransactionRepository repository;

    public List<Transaction> getExpensesForTagsByDates() {
//        HashMap<String, Integer> responseMap = new HashMap<>();

        List<Transaction> transactions = repository.findByTypeDate("expense", LocalDateTime.now().minusMonths(3), LocalDateTime.now());
//        .stream()
//                .collect(groupingBy(Transaction::getTags));
//        responseMap.put()
//        System.out.println(LocalDateTime.now());
//        System.out.println(LocalDateTime.now().minusMonths(1));
//        List<Transaction> transactionList = repository.findByDate(LocalDateTime.parse("2022-10-25T09:57:00"));
        return transactions;
    }
}
