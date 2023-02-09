package backend.solutionRecouvrement.auth.controllers;

import backend.solutionRecouvrement.auth.entities.Role;
import backend.solutionRecouvrement.auth.entities.User;
import backend.solutionRecouvrement.auth.repositories.RoleRepository;
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
@Tag(name = "Role")
public class RoleController {
    @Autowired
    AccountService accountService;
    @Autowired
    RoleRepository roleRepository;
    @Operation(summary = "Create Role")
    @PostMapping({"/role/createRole"})
    public ResponseEntity<Role> saveRoles(@RequestBody Role role) {
        try {
            this.accountService.addNewRolle(role);
            return new ResponseEntity(role, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Gets All Roles")
    @GetMapping({"/role/getAllRoles"})
    public ResponseEntity<List<Role>> getRoles() {
        try {
            List<Role> role = this.accountService.ListRoles();
            return role.isEmpty() ? new ResponseEntity("La liste des role est vide ", HttpStatus.NO_CONTENT) : new ResponseEntity(role, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Update Role")
    @PutMapping({"/role/updateRole/{id_role}"})
    public ResponseEntity<User> UpdateUser(@PathVariable Long id_role, @RequestBody Role role) {
        try {
            Optional<Role> RoleData = this.roleRepository.findById(id_role);
            return RoleData.isPresent() ? new ResponseEntity(this.accountService.UpdateRole(id_role, role), HttpStatus.CREATED) : new ResponseEntity("le role n'existe pas ", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Delete Role")
    @DeleteMapping({"/role/deleteRole/{id_Role}"})
    public ResponseEntity<?> DeleteRole(@PathVariable Long id_Role) {
        try {
            this.accountService.DeleteRole(id_Role);
            return new ResponseEntity("Role Deleted", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
