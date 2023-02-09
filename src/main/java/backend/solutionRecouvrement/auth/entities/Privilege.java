package backend.solutionRecouvrement.auth.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Privilege")
public class Privilege implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            name = "Privilegename"
    )
    private String nameP;
    @Column(
            name = "Descriptions"
    )
    private String Description;
    @OneToMany(
            mappedBy = "privileges"
    )
    @JsonIgnore
    private List<Permissions> permissions = new ArrayList();

    public Privilege() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameP() {
        return this.nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public List<Permissions> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(List<Permissions> permissions) {
        this.permissions = permissions;
    }

    public Privilege(Long id, String nameP, String description, List<Permissions> permissions) {
        this.id = id;
        this.nameP = nameP;
        this.Description = description;
        this.permissions = permissions;
    }
}
