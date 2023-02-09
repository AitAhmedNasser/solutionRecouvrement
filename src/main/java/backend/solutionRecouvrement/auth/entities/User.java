package backend.solutionRecouvrement.auth.entities;



import backend.solutionRecouvrement.entities.Action;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(
        name = "Utilisateur"
)
public class User implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "USER_ID"
    )
    private Long id;
    @Column(
            name = "nom"
    )
    private String nom;
    @Column(
            name = "prenom"
    )
    private String prenom;
    @Column(
            name = "userName"
    )
    private String userName;
    @Column(
            name = "email"
    )
    private String email;
    @JsonProperty(
            access = Access.WRITE_ONLY
    )
    @Nullable
    @Column(
            name = "password"
    )
    private String password;
    @ManyToOne
    private Role role;
    @ManyToOne
    @JoinColumns({@JoinColumn(
            name = "AGENCE_ID",
            foreignKey = @ForeignKey(
                    name = "FK_AGENCE_ID"
            ),
            referencedColumnName = "AGENCE_ID"
    )})
    private Agence agence;
    @ManyToOne
    @JoinColumns({@JoinColumn(
            name = "ID_ACTION",
            foreignKey = @ForeignKey(
                    name = "FK_ID_ACTION"
            ),
            referencedColumnName = "ID_ACTION"
    )})
    private Action action;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Agence getAgence() {
        return this.agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public User() {
    }

    public User(Long id, String nom, String prenom, String userName, String email, String password, Role role, Agence agence) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.agence = agence;
    }

    public Action getAction() {
        return this.action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public User(Long id, String nom, String prenom, String userName, String email, String password, Role role, Agence agence, Action action) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.agence = agence;
        this.action = action;
    }
}
