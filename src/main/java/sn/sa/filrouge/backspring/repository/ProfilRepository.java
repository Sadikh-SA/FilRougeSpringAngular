package sn.sa.filrouge.backspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.sa.filrouge.backspring.model.Profil;

import java.util.Optional;


@Repository
public interface ProfilRepository extends JpaRepository<Profil, Integer> {

}