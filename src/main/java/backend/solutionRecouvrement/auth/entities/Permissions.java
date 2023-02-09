package backend.solutionRecouvrement.auth.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Permissions")
public class Permissions implements Serializable {
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Id
    private Long id;
    @ManyToOne
    private Privilege privileges;
    @ManyToOne
    private Ressource ressources;
    @Column(
            name = "Permission_Name"
    )
    @JsonProperty(
            access = Access.READ_ONLY
    )
    private String namePermission;

    public Permissions() {
    }

    public Permissions(Privilege privileges, Ressource ressources, String namepermission) {
        this.privileges = privileges;
        this.ressources = ressources;
        this.namePermission = namepermission;
    }

    public Permissions(Long id, Privilege privileges, Ressource ressources, String namepermission) {
        this.id = id;
        this.privileges = privileges;
        this.ressources = ressources;
        this.namePermission = namepermission;
    }

    public String getNamepermission() {
        return this.namePermission;
    }

    public void setNamepermission(String namepermission) {
        this.namePermission = namepermission;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Privilege getPrivileges() {
        return this.privileges;
    }

    public void setPrivileges(Privilege privileges) {
        this.privileges = privileges;
    }

    public Ressource getRessources() {
        return this.ressources;
    }

    public void setRessources(Ressource ressources) {
        this.ressources = ressources;
    }
}