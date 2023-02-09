package backend.solutionRecouvrement.DependencyInjection;

import backend.solutionRecouvrement.entities.Compte;
import backend.solutionRecouvrement.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService {
    @Autowired
    CompteRepository compteRepository;

    public CompteService() {
    }

    public void saveAllCompte(List<Compte> comptes) {
        this.compteRepository.saveAll(comptes);
    }
}

