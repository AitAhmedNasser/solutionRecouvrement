package backend.solutionRecouvrement.auth.controllers;

import backend.solutionRecouvrement.auth.entities.Agence;
import backend.solutionRecouvrement.auth.repositories.AgenceRepository;
import backend.solutionRecouvrement.auth.services.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/api"})
@CrossOrigin({"*"})
@Tag(name = "Agence")
public class AgenceController {
    @Autowired
    AccountService accountService;
    @Autowired
    AgenceRepository agenceRepository;

    @Operation(summary = "Create Agence")
    @PostMapping({"/agence/createAgence"})
    public ResponseEntity<Agence> AddAgence(@RequestBody Agence agence) throws Exception {
        try {
            this.accountService.AddAgence(agence);
            return new ResponseEntity(agence, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Get All Agences")
    @GetMapping({"/agence/getAllAgences"})
    public ResponseEntity<List<Agence>> AllAgence() {
        try {
            List<Agence> agences = this.accountService.AllAgence();
            return agences.isEmpty() ? new ResponseEntity("Liste Agences est null", HttpStatus.NO_CONTENT) : new ResponseEntity(agences, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Get Agence BY Id")
    @GetMapping({"/agence/getAgenceById/{id_agence}"})
    public ResponseEntity getAgenceByID(@PathVariable Long id_agence) throws Exception {
        try {
            Agence agence = this.accountService.getAgenceByID(id_agence);
            if (agence == null) {
                throw new Exception("L'Agence n'existe pas ");
            } else {
                return new ResponseEntity(agence, HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(summary = "Update Agence")
    @PutMapping({"/agence/updateAgence/{id_agence}"})
    public ResponseEntity<Agence> UpdateAgence(@PathVariable Long id_agence, @RequestBody Agence agence) {
        try {
            Optional<Agence> AgenceData = this.agenceRepository.findById(id_agence);
            return AgenceData.isPresent() ? new ResponseEntity(this.accountService.UpdateAgence(id_agence, agence), HttpStatus.CREATED) : new ResponseEntity("cette Agence n'existe pas ", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Delete Agence")
    @DeleteMapping({"/agence/deleteAgence/{id_Agence}"})
    public ResponseEntity<?> DeleteAgence(@PathVariable Long id_Agence) {
        try {
            this.accountService.DeleteAgence(id_Agence);
            return new ResponseEntity("Agence Deleted", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
