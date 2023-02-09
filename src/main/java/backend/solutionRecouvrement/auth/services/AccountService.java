package backend.solutionRecouvrement.auth.services;

import backend.solutionRecouvrement.auth.entities.Agence;
import backend.solutionRecouvrement.auth.entities.Role;
import backend.solutionRecouvrement.auth.entities.User;
import backend.solutionRecouvrement.entities.Action;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    User addNewUser(User user) throws Exception;

    List<User> ListUsers();

    User getUserByUserName(String userName);

    User getUserByMail(String userEmail);

    User getUserById(Long id_user) throws Exception;

    void DeleteUser(Long id_user) throws Exception;

    User UpdateUser(Long id_user, User user) throws Exception;

    User UpdatePasswordUser(String Password, Long UserId);

    Role createRole(Role role) throws Exception;

    Role addNewRolle(Role role);

    List<Role> ListRoles() throws Exception;

    Role getRoleById(Long id_role);

    void DeleteRole(Long id_Role) throws Exception;

    Role UpdateRole(Long id_role, Role role) throws Exception;

    Agence AddAgence(Agence agence) throws Exception;

    List<Agence> AllAgence();

    Agence getAgenceByID(Long id_Agence);

    void DeleteAgence(Long id_Agence) throws Exception;

    Agence UpdateAgence(Long id_agence, Agence agence) throws Exception;

    Action AddAction(Action action) throws Exception;
}