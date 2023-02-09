package backend.solutionRecouvrement.entities;

import jakarta.persistence.*;

@Entity
@Table(
        name = "portefeuille"
)
public class Portefeuille {
    @Id
    @Column(
            name = "ID_PORTEFUILLE"
    )
    private Long portefeuilleId;
    @Column(
            name = "NOM_PORTEFUILLE"
    )
    private String portefeuilleNom;
    @Column(
            name = "DESCRIPTION_PORTEFUILLE"
    )
    private String portefeuilleDescription;
    @OneToOne
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

    public Long getPortefeuilleId() {
        return this.portefeuilleId;
    }

    public void setPortefeuilleId(Long portefeuilleId) {
        this.portefeuilleId = portefeuilleId;
    }

    public String getPortefeuilleNom() {
        return this.portefeuilleNom;
    }

    public void setPortefeuilleNom(String portefeuilleNom) {
        this.portefeuilleNom = portefeuilleNom;
    }

    public String getPortefeuilleDescription() {
        return this.portefeuilleDescription;
    }

    public void setPortefeuilleDescription(String portefeuilleDescription) {
        this.portefeuilleDescription = portefeuilleDescription;
    }

    public Portefeuille() {
    }

    public Portefeuille(Long portefeuilleId, String portefeuilleNom, String portefeuilleDescription) {
        this.portefeuilleId = portefeuilleId;
        this.portefeuilleNom = portefeuilleNom;
        this.portefeuilleDescription = portefeuilleDescription;
    }

    public Scenario getScenario() {
        return this.scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public Portefeuille(Long portefeuilleId, String portefeuilleNom, String portefeuilleDescription, Scenario scenario) {
        this.portefeuilleId = portefeuilleId;
        this.portefeuilleNom = portefeuilleNom;
        this.portefeuilleDescription = portefeuilleDescription;
        this.scenario = scenario;
    }
}