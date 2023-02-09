package backend.solutionRecouvrement.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "scenario"
)
public class Scenario {
    @Id
    @Column(
            name = "ID_SCENARIO"
    )
    private Long scenarioId;
    private String scenarioNom;
    private String scenarioEtape;
    @OneToMany(
            mappedBy = "scenario"
    )
    @JsonIgnore
    private List<Action> listActions = new ArrayList();
    @OneToMany(
            mappedBy = "scenario"
    )
    @JsonIgnore
    private List<Client> listClients = new ArrayList();
    @OneToOne
    @JoinColumn(
            name = "ID_PORTEFUILLE"
    )
    private Portefeuille portefeuille;
    @OneToMany(
            mappedBy = "scenario"
    )
    private List<Client> clients;
    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true
    )
    @JoinColumn(
            name = "ID_SCENARIO"
    )
    private List<Status> status;

    public Long getScenarioId() {
        return this.scenarioId;
    }

    public void setScenarioId(Long scenarioId) {
        this.scenarioId = scenarioId;
    }

    public String getScenarioNom() {
        return this.scenarioNom;
    }

    public void setScenarioNom(String scenarioNom) {
        this.scenarioNom = scenarioNom;
    }

    public String getScenarioEtape() {
        return this.scenarioEtape;
    }

    public void setScenarioEtape(String scenarioEtape) {
        this.scenarioEtape = scenarioEtape;
    }

    public List<Action> getListActions() {
        return this.listActions;
    }

    public void setListActions(List<Action> listActions) {
        this.listActions = listActions;
    }

    public List<Client> getListClients() {
        return this.listClients;
    }

    public void setListClients(List<Client> listClients) {
        this.listClients = listClients;
    }

    public Portefeuille getPortefeuille() {
        return this.portefeuille;
    }

    public void setPortefeuille(Portefeuille portefeuille) {
        this.portefeuille = portefeuille;
    }

    public Scenario() {
    }

    public Scenario(Long scenarioId, String scenarioNom, String scenarioEtape, List<Action> listActions, List<Client> listClients, Portefeuille portefeuille) {
        this.scenarioId = scenarioId;
        this.scenarioNom = scenarioNom;
        this.scenarioEtape = scenarioEtape;
        this.listActions = listActions;
        this.listClients = listClients;
        this.portefeuille = portefeuille;
    }

    public List<Client> getClients() {
        return this.clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Scenario(Long scenarioId, String scenarioNom, String scenarioEtape, List<Action> listActions, List<Client> listClients, Portefeuille portefeuille, List<Client> clients) {
        this.scenarioId = scenarioId;
        this.scenarioNom = scenarioNom;
        this.scenarioEtape = scenarioEtape;
        this.listActions = listActions;
        this.listClients = listClients;
        this.portefeuille = portefeuille;
        this.clients = clients;
    }

    public List<Status> getStatus() {
        return this.status;
    }

    public void setStatuses(List<Status> status) {
        this.status = status;
    }

    public Scenario(Long scenarioId, String scenarioNom, String scenarioEtape, List<Action> listActions, List<Client> listClients, Portefeuille portefeuille, List<Client> clients, List<Status> status) {
        this.scenarioId = scenarioId;
        this.scenarioNom = scenarioNom;
        this.scenarioEtape = scenarioEtape;
        this.listActions = listActions;
        this.listClients = listClients;
        this.portefeuille = portefeuille;
        this.clients = clients;
        this.status = status;
    }
}
