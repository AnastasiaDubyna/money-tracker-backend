package com.example.backend.model;



import com.example.backend.utils.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Integer amount;
    private String type;
    private Date date;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "transaction_tags", joinColumns = @JoinColumn(name = "transaction_id"))
    @Column(name = "tags")
    private List<String> tags = new ArrayList<>();




}
