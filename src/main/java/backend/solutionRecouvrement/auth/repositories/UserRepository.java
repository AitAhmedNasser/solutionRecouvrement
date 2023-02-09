package backend.solutionRecouvrement.auth.repositories;

import backend.solutionRecouvrement.auth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserById(Long id_User);

    User getUserByEmail(String UserEmail);

    User getUserByUserName(String userName);
}

