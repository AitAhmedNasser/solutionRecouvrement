package backend.solutionRecouvrement.auth.repositories;


import backend.solutionRecouvrement.entities.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
    Action findByActionName(String actionName);

    Action getActionById(Long id_Agence);
}
