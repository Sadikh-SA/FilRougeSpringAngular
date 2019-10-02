package sn.sa.filrouge.backspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.sa.filrouge.backspring.model.Compte;

import java.util.Optional;


@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {
    Optional<Compte> findCompteByNumeroCompte(double numeroCompte);
    Optional<Compte> findCompteById(int id);

}