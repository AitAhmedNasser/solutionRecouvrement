package backend.solutionRecouvrement.auth.repositories;

import backend.solutionRecouvrement.auth.entities.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AgenceRepository extends JpaRepository<Agence, Long> {
    Agence findByAgenceName(String agenceName);

    Agence getAgenceById(Long id_Agence);
}

