package com.example.backend.repository;

import com.example.backend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query(
        value="SELECT  id, date, type, transaction_id, tags, amount FROM transaction t INNER JOIN transaction_tags ts ON(t.id=ts.transaction_id) " +
                "WHERE type=?1 " +
                "AND date between ?2 AND ?3",
        nativeQuery = true)
    List<Transaction> findByTypeDate(String type, LocalDateTime startDate, LocalDateTime endDate);

    @Query(
        value="SELECT * FROM transaction t INNER JOIN transaction_tags ts ON(t.id=ts.transaction_id) WHERE date=?1",
        nativeQuery = true
    )
    List<Transaction> findByDate(LocalDateTime dateTime);
}
