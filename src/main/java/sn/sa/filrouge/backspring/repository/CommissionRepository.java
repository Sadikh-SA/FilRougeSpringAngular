package sn.sa.filrouge.backspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.sa.filrouge.backspring.model.Commission;

import java.util.Optional;


@Repository
public interface CommissionRepository extends JpaRepository<Commission, Integer> {

}