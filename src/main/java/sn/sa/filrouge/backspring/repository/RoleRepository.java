package sn.sa.filrouge.backspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.sa.filrouge.backspring.model.Role;
import sn.sa.filrouge.backspring.model.RoleName;


import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
