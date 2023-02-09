package backend.solutionRecouvrement.auth.controllers;

import backend.solutionRecouvrement.auth.entities.Agence;
import backend.solutionRecouvrement.auth.entities.Role;
import backend.solutionRecouvrement.auth.entities.User;
import backend.solutionRecouvrement.auth.repositories.AgenceRepository;
import backend.solutionRecouvrement.auth.repositories.RoleRepository;
import backend.solutionRecouvrement.auth.repositories.UserRepository;
import backend.solutionRecouvrement.auth.services.AccountService;
import backend.solutionRecouvrement.entities.Action;
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
@Tag(name = "User")
public class UserController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RoleRepository roleRepo;
    @Autowired
    private AgenceRepository ageneceRepo;


    @Operation(summary = "Create User")
    @RequestMapping(
            value = {"/user/createUser"},
            method = {RequestMethod.POST}
    )
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        try {
            this.accountService.addNewUser(user);
            return new ResponseEntity(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping({"/user/getAllUsers"})
    @Operation(summary = "Gets all Users")
    public ResponseEntity<List<User>> getUsers() {
        try {
            List<User> user = this.accountService.ListUsers();
            return user.isEmpty() ? new ResponseEntity("Liste Users est null", HttpStatus.NO_CONTENT) : new ResponseEntity(user, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Gets User By Id")
    @GetMapping({"/user/getUserById/{id_user}"})
    public ResponseEntity getUserById(@PathVariable("id_user") Long id_user) throws Exception {
        try {
            User user = this.accountService.getUserById(id_user);
            if (user == null) {
                throw new Exception("L'Utilisateur n'existe pas ");
            } else {
                return new ResponseEntity(user, HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Gets User By Email")
    @GetMapping({"/user/getUserByEmail/{userEmail}"})
    public ResponseEntity getUserByMail(@PathVariable String userEmail) throws Exception {
        try {
            User user = this.accountService.getUserByMail(userEmail);
            if (user == null) {
                throw new Exception("L'Utilisateur n'existe pas ");
            } else {
                return new ResponseEntity(user, HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Gets User By User Name")
    @GetMapping({"/user/getUserByUserName/{userName}"})
    public ResponseEntity getUserByUserName(@PathVariable("userName") String userName) throws Exception {
        try {
            User user = this.accountService.getUserByUserName(userName);
            if (user == null) {
                throw new Exception("L'Utilisateur n'existe pas ");
            } else {
                return new ResponseEntity(user, HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Update User")
    @PutMapping({"/user/updateUser/{id_user}"})
    public ResponseEntity<User> UpdateUser(@PathVariable Long id_user, @RequestBody User user) {
        try {
            Optional<User> UserData = this.userRepo.findById(id_user);
            return UserData.isPresent() ? new ResponseEntity(this.accountService.UpdateUser(id_user, user), HttpStatus.CREATED) : new ResponseEntity("l'utilisateur n'existe pas ", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Delete User")
    @DeleteMapping({"/user/deleteUser/{id_user}"})
    public ResponseEntity<?> DeleteUser(@PathVariable Long id_user) {
        try {
            this.accountService.DeleteUser(id_user);
            return new ResponseEntity("User Deleted", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Operation(
            summary = "Create Action"
    )
    @PostMapping({"/action/createAction"})
    public ResponseEntity<Action> AddAgence(@RequestBody Action action) throws Exception {
        try {
            this.accountService.AddAction(action);
            return new ResponseEntity(action, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}