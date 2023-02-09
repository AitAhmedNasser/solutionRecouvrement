package backend.solutionRecouvrement.DependencyInjection;

import backend.solutionRecouvrement.auth.entities.Agence;
import backend.solutionRecouvrement.auth.repositories.AgenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceService {
    AgenceRepository agenceRepository;

    public AgenceService() {
    }

    public void saveAllAgences(List<Agence> agences) {
        this.agenceRepository.saveAll(agences);
    }
}