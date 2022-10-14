package com.example.backend.model;



import com.example.backend.utils.TransactionType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Transaction {

    public Transaction() {

    }

    public Transaction(Integer id, Integer amount, String type, Date date, List<String> tags) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.tags = tags;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Integer amount;
    private String type;
    private Date date;
    @ElementCollection
    @CollectionTable(name = "transaction_tags", joinColumns = @JoinColumn(name = "transaction_id"))
    @Column(name = "tags")
    private List<String> tags = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getTags() {
        return tags;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }


}
