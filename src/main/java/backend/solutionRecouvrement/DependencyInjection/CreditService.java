package backend.solutionRecouvrement.DependencyInjection;

import backend.solutionRecouvrement.entities.Credit;
import backend.solutionRecouvrement.repositories.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditService {
    @Autowired
    CreditRepository creditRepository;

  /*  public CreditService() {
    }*/

    public void saveAllCredit(List<Credit> credits) {
        this.creditRepository.saveAll(credits);
    }

    public Credit saveOneCredit(Credit credit) {
        return (Credit)this.creditRepository.save(credit);
    }
}

