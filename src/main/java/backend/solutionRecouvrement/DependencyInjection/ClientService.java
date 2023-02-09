package backend.solutionRecouvrement.DependencyInjection;

import backend.solutionRecouvrement.entities.Client;
import backend.solutionRecouvrement.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public ClientService() {
    }

    public void saveAllClients(List<Client> clients) {
        this.clientRepository.saveAll(clients);
    }
}
