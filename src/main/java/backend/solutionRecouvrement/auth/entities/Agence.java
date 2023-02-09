package backend.solutionRecouvrement.auth.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Agence")
public class Agence implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "AGENCE_ID"
    )
    private Long id;
    @Column(
            name = "Nom_agence"
    )
    private String agenceName;
    @Column(
            name = "Code_agence"
    )
    private String codeAgence;
    @Column(
            name = "Zone_agence"
    )
    private String zoneAgence;
    @Column(
            name = "description"
    )
    private String description;
    @OneToMany(
            mappedBy = "agence"
    )
    @JsonIgnore
    private List<User> users = new ArrayList();

    public Agence() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameAgence() {
        return this.agenceName;
    }

    public void setNameAgence(String nameAgence) {
        this.agenceName = nameAgence;
    }

    public String getCodeAgence() {
        return this.codeAgence;
    }

    public void setCodeAgence(String codeAgence) {
        this.codeAgence = codeAgence;
    }

    public String getZoneAgence() {
        return this.zoneAgence;
    }

    public void setZoneAgence(String zoneAgence) {
        this.zoneAgence = zoneAgence;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Agence(Long id, String nameAgence, String codeAgence, String zoneAgence, String description, List<User> users) {
        this.id = id;
        this.agenceName = nameAgence;
        this.codeAgence = codeAgence;
        this.zoneAgence = zoneAgence;
        this.description = description;
        this.users = users;
    }
}

