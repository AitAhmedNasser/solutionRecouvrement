package backend.solutionRecouvrement.auth.repositories;


import backend.solutionRecouvrement.auth.entities.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    Privilege getPrivilegeBynameP(String nameP);

    Privilege getPrivilegeById(Long id_Privileges);
}

