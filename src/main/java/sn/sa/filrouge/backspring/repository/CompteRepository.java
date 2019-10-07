package sn.sa.filrouge.backspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.sa.filrouge.backspring.model.Compte;
import sn.sa.filrouge.backspring.model.Partenaire;

import java.util.List;
import java.util.Optional;


@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {
    Optional<Compte> findCompteByNumeroCompte(double numeroCompte);
    Optional<Compte> findCompteById(int id);
    List<Compte> findComptesByPartenaire(Partenaire partenaire);

}