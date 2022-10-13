package com.example.backend.utils;

import com.example.backend.model.Transaction;

import java.util.ArrayList;

public class TransactionsList {
    
    private ArrayList<Transaction> transactions;

    public TransactionsList() {
        transactions = new ArrayList<>();
    }

    public TransactionsList(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    
}
