package backend.solutionRecouvrement.services;

import backend.solutionRecouvrement.entities.Client;
import backend.solutionRecouvrement.entities.Compte;
import backend.solutionRecouvrement.entities.Credit;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;


public interface GestionCreditService {

    //client
    Client addToClient(Client client) ;
    List<Client> getallClient();
    ResponseEntity<Client> updateProduit(Client client);
    List<String> getClientByDateRepo(Integer year);

    //Credit
    Credit addToCredit(Credit credit);

    //compte
    Compte addTocompte(Compte compte);
    List<Compte>getAllcompte();

}
