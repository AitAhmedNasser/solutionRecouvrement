package backend.solutionRecouvrement.auth.services.ServiceImpl;

import backend.solutionRecouvrement.auth.entities.Agence;
import backend.solutionRecouvrement.auth.entities.Permissions;
import backend.solutionRecouvrement.auth.entities.Role;
import backend.solutionRecouvrement.auth.entities.User;
import backend.solutionRecouvrement.auth.repositories.*;
import backend.solutionRecouvrement.auth.services.AccountService;
import backend.solutionRecouvrement.entities.Action;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PermissionRepository permissionsRepo;
    @Autowired
    private AgenceRepository agenceRepo;
    @Autowired
    private ActionRepository actionRepository;

    public AccountServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public User addNewUser(User user) throws Exception {
        Optional<Role> role = this.roleRepository.findById(user.getRole().getId());
        User userByUsername = this.userRepository.getUserByUserName(user.getUserName());
        if (role == null) {
            throw new Exception("Ce Role n'existe pas ");
        } else if (userByUsername != null) {
            throw new Exception("Cette utilisiteur existe deja  ");
        } else {
            String Pws = user.getPassword();
            return (User)this.userRepository.save(user);
        }
    }

    public Role addNewRolle(Role role) {
        return (Role)this.roleRepository.save(role);
    }

    public Role createRole(Role role) throws Exception {
        Set<Permissions> permmissionnsList = new HashSet();
        Set permissions = (Set)role.getPermissions().stream().map((permission) -> {
            Permissions perm = this.permissionsRepo.getPermissionById(permission.getId());
            permmissionnsList.add(perm);
            return permission;
        }).collect(Collectors.toSet());
        new Role((Object)null, role.getNom(), permmissionnsList);
        return (Role)this.roleRepository.save(role);
    }

    public Agence AddAgence(Agence agence) throws Exception {
        Agence agenceName = this.agenceRepo.findByAgenceName(agence.getNameAgence());
        if (agenceName != null) {
            throw new Exception("L'agence existe deja");
        } else {
            return (Agence)this.agenceRepo.save(agence);
        }
    }

    public List<User> ListUsers() {
        return this.userRepository.findAll();
    }

    public User getUserByUserName(String userName) {
        return this.userRepository.getUserByUserName(userName);
    }

    public User getUserByMail(String userEmail) {
        return this.userRepository.getUserByEmail(userEmail);
    }

    public List<Role> ListRoles() throws Exception {
        List<Role> role = this.roleRepository.findAll();
        if (role == null) {
            throw new Exception("La liste des roles est vide ");
        } else {
            return this.roleRepository.findAll();
        }
    }

    public List<Agence> AllAgence() {
        return this.agenceRepo.findAll();
    }

    public void DeleteUser(Long id_user) throws Exception {
        User user = this.userRepository.getUserById(id_user);
        if (user == null) {
            throw new Exception("Utilisateur not found ");
        } else {
            this.userRepository.deleteById(id_user);
        }
    }

    public void DeleteRole(Long id_Role) throws Exception {
        Role role = this.roleRepository.getRoleById(id_Role);
        List<User> ListUsersRole = role.getUsers();
        if (role == null) {
            throw new Exception("Role not found ");
        } else {
            this.roleRepository.deleteById(id_Role);
        }
    }

    public void DeleteAgence(Long id_Agence) throws Exception {
        Agence agence = this.agenceRepo.getAgenceById(id_Agence);
        if (agence == null) {
            throw new Exception("Agence is  not found ");
        } else {
            this.agenceRepo.deleteById(id_Agence);
        }
    }

    public User UpdateUser(Long id_user, User user) throws Exception {
        User users = (User)this.userRepository.findById(id_user).get();
        Role role = this.roleRepository.getRoleById(user.getRole().getId());
        Agence agence = this.agenceRepo.getAgenceById(user.getAgence().getId());
        if (users == null) {
            throw new Exception("L'utilisateur dans id  " + id_user + " not existe");
        } else if (role != null && agence != null) {
            users.setNom(user.getNom());
            users.setPrenom(user.getPrenom());
            users.setEmail(user.getEmail());
            users.setRole(role);
            users.getRole().setNom(role.getNom());
            users.getRole().setPermissions(role.getPermissions());
            users.setAgence(agence);
            users.getAgence().setNameAgence(agence.getNameAgence());
            users.getAgence().setDescription(agence.getDescription());
            return (User)this.userRepository.save(users);
        } else {
            throw new Exception("le role ou l'agence n'existe pas ");
        }
    }

    public User UpdatePasswordUser(String Password, Long UserId) {
        User user = this.userRepository.getUserById(UserId);
        return (User)this.userRepository.save(user);
    }

    public Role UpdateRole(Long id_role, Role role) throws Exception {
        Role roleData = (Role)this.roleRepository.findById(id_role).get();
        Set<Permissions> permmissionnsList = new HashSet();
        Set permissions = (Set)role.getPermissions().stream().map((permission) -> {
            Permissions perm = this.permissionsRepo.getPermissionById(permission.getId());
            permmissionnsList.add(perm);
            return permission;
        }).collect(Collectors.toSet());
        if (roleData == null) {
            throw new Exception("Le role n'existe pas dans la base de donnée");
        } else {
            roleData.setNom(role.getNom());
            roleData.setPermissions(permmissionnsList);
            return (Role)this.roleRepository.save(roleData);
        }
    }

    public Agence UpdateAgence(Long id_agence, Agence agence) throws Exception {
        Agence agenceData = (Agence)this.agenceRepo.findById(id_agence).get();
        if (agenceData == null) {
            throw new Exception("L'agence n'existe pas dans la base de donnée");
        } else if (agenceData.getNameAgence() != agence.getNameAgence() && agenceData.getNameAgence() != agence.getNameAgence()) {
            agenceData.setNameAgence(agence.getNameAgence());
            agenceData.setDescription(agence.getDescription());
            return (Agence)this.agenceRepo.save(agenceData);
        } else {
            throw new Exception("L'agence existe déja dans la base de donnée");
        }
    }

    public User getUserById(Long id_user) throws Exception {
        User user = (User)this.userRepository.findById(id_user).get();
        if (user == null) {
            throw new Exception("L'Utilisateur n'existe pas ");
        } else {
            return (User)this.userRepository.findById(id_user).get();
        }
    }

    public Role getRoleById(Long id_role) {
        return (Role)this.roleRepository.findById(id_role).get();
    }

    public Agence getAgenceByID(Long id_Agence) {
        return (Agence)this.agenceRepo.findById(id_Agence).get();
    }

    public Action AddAction(Action action) throws Exception {
        Action actionName = this.actionRepository.findByActionName(action.getActionName());
        if (actionName != null) {
            throw new Exception("L'agence existe deja");
        } else {
            return (Action)this.actionRepository.save(actionName);
        }
    }
}

