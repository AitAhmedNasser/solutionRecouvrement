package backend.solutionRecouvrement.controllers;

import backend.solutionRecouvrement.entities.Client;
import backend.solutionRecouvrement.services.GestionCreditService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/api"})
@CrossOrigin({"*"})
@Tag(name = "Client")
public class ClientController {
    @Autowired
    GestionCreditService gestionCreditService;

    @PostMapping({"/saveClient"})
    public Client saveClient(@RequestBody Client client) {
        return this.gestionCreditService.addToClient(client);
    }
}
