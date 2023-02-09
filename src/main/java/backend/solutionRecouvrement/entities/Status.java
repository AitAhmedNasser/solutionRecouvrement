package backend.solutionRecouvrement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "status"
)
public class Status {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(
            name = "ID_SCENARIO",
            foreignKey = @ForeignKey(
                    name = "FK_ID_SCENARIO"
            ),
            referencedColumnName = "ID_SCENARIO",
            insertable = false,
            updatable = false
    )
    private Scenario scenario;

    public Status() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Scenario getScenario() {
        return this.scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public Status(Long id, String name, Scenario scenario) {
        this.id = id;
        this.name = name;
        this.scenario = scenario;
    }
}
