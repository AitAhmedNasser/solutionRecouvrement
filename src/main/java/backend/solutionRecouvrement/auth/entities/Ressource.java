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
import org.springframework.lang.Nullable;

@Entity
@Table(
        name = "Ressource"
)
public class Ressource implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            name = "nom_Res"
    )
    @Nullable
    private String name;
    @Column(
            name = "Description"
    )
    private String Description;
    @OneToMany(
            mappedBy = "ressources"
    )
    @JsonIgnore
    private List<Permissions> permissions = new ArrayList();

    public Ressource() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
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

    public Ressource(Long id, @Nullable String name, String description, List<Permissions> permissions) {
        this.id = id;
        this.name = name;
        this.Description = description;
        this.permissions = permissions;
    }
}

