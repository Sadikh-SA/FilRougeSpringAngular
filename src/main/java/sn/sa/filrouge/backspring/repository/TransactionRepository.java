package sn.sa.filrouge.backspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.sa.filrouge.backspring.model.Transaction;
import sn.sa.filrouge.backspring.model.User;

import java.util.Optional;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}