package backend.solutionRecouvrement.auth.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(
        name = "Role"
)
public class Role implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private Long id;
    @Column(
            name = "nom"
    )
    private String name;
    @OneToMany
    private List<User> users = new ArrayList();
    @ManyToMany
    @JoinTable(
            name = "roles_permissions",
            joinColumns = {@JoinColumn(
                    name = "role_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "permission_id"
            )}
    )
    Set<Permissions> permissions = new HashSet();

    public Role() {
    }

    public Role(Object o, String nom, Set<Permissions> permmissionnsList) {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.name;
    }

    public void setNom(String nom) {
        this.name = nom;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Set<Permissions> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(Set<Permissions> permissions) {
        this.permissions = permissions;
    }

    public Role(Long id, String nom, List<User> users, Set<Permissions> permissions) {
        this.id = id;
        this.name = nom;
        this.users = users;
        this.permissions = permissions;
    }
}
