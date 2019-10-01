package sn.sa.filrouge.backspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.sa.filrouge.backspring.model.Depot;

import java.util.Optional;


@Repository
public interface DepotRepository extends JpaRepository<Depot, Integer> {

}