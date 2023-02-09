package backend.solutionRecouvrement.services;

import backend.solutionRecouvrement.entities.Client;
import backend.solutionRecouvrement.entities.Compte;
import backend.solutionRecouvrement.entities.Credit;
import backend.solutionRecouvrement.repositories.ClientRepository;
import backend.solutionRecouvrement.repositories.CompteRepository;
import backend.solutionRecouvrement.repositories.CreditRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Service

@Transactional
public class GestionCreditServiceImpl implements GestionCreditService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CreditRepository creditRepository;
    @Autowired
    CompteRepository compteRepository;
    @Override
    public Client addToClient(Client client) {
        return null;
    }

    @Override
    public List<Client> getallClient() {
        List<Client> allClient = new ArrayList<Client>();
        allClient = clientRepository.findAll();
        return allClient;
    }


    @Override
    public ResponseEntity<Client> updateProduit(Client client) {
        return null;
    }

    @Override
    public List<String> getClientByDateRepo(Integer year) {
        List<String> daterepo = new ArrayList<String>();
        daterepo = clientRepository.findByReportingDate(year);
        return daterepo;
    }

    @Override
    public Credit addToCredit(Credit credit) {
        return creditRepository.save(credit);
    }

    @Override
    public Compte addTocompte(Compte compte) {
        return compteRepository.save(compte);
    }

    @Override
    public List<Compte> getAllcompte() {
        return null;
    }






}
