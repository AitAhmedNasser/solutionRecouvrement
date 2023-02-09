package backend.solutionRecouvrement.entities;


import backend.solutionRecouvrement.auth.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(
        name = "action"
)
public class Action {
    @Id
    @Column(
            name = "ID_ACTION"
    )
    private Long id;
    @Column(
            name = "NAME_ACTION"
    )
    private String actionName;
    @Column(
            name = "DATE_DEBUT_ACTION"
    )
    private Date dateDebutAction;
    @Column(
            name = "ACTION_STATUS"
    )
    private String actionStatus;
    @Column(
            name = "ACTION_DESCRIPTION"
    )
    private String actionDescription;
    @ManyToOne
    private Echeance echeance;
    @ManyToOne
    private Scenario scenario;
    @ManyToOne
    @JoinColumns({@JoinColumn(
            name = "client_ID_CLIENT",
            foreignKey = @ForeignKey(
                    name = "FK_ID_CLIENT"
            ),
            referencedColumnName = "ID_CLIENT"
    ), @JoinColumn(
            name = "client_reportingDate",
            foreignKey = @ForeignKey(
                    name = "FK_reportingDate"
            ),
            referencedColumnName = "reportingDate"
    )})
    private Client client;
    @ManyToOne
    @JoinColumns({@JoinColumn(
            name = "USER_ID",
            foreignKey = @ForeignKey(
                    name = "FK_USER_ID"
            ),
            referencedColumnName = "USER_ID"
    )})
    private User user;

    public Action() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActionName() {
        return this.actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Date getDateDebutAction() {
        return this.dateDebutAction;
    }

    public void setDateDebutAction(Date dateDebutAction) {
        this.dateDebutAction = dateDebutAction;
    }

    public String getActionStatus() {
        return this.actionStatus;
    }

    public void setActionStatus(String actionStatus) {
        this.actionStatus = actionStatus;
    }

    public String getActionDescription() {
        return this.actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public Echeance getEcheance() {
        return this.echeance;
    }

    public void setEcheance(Echeance echeance) {
        this.echeance = echeance;
    }

    public Action(Long id, String actionName, Date dateDebutAction, String actionStatus, String actionDescription, Echeance echeance) {
        this.id = id;
        this.actionName = actionName;
        this.dateDebutAction = dateDebutAction;
        this.actionStatus = actionStatus;
        this.actionDescription = actionDescription;
        this.echeance = echeance;
    }

    public Scenario getScenario() {
        return this.scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public Action(Long id, String actionName, Date dateDebutAction, String actionStatus, String actionDescription, Echeance echeance, Scenario scenario) {
        this.id = id;
        this.actionName = actionName;
        this.dateDebutAction = dateDebutAction;
        this.actionStatus = actionStatus;
        this.actionDescription = actionDescription;
        this.echeance = echeance;
        this.scenario = scenario;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Action(Long id, String actionName, Date dateDebutAction, String actionStatus, String actionDescription, Echeance echeance, Scenario scenario, Client client, User user) {
        this.id = id;
        this.actionName = actionName;
        this.dateDebutAction = dateDebutAction;
        this.actionStatus = actionStatus;
        this.actionDescription = actionDescription;
        this.echeance = echeance;
        this.scenario = scenario;
        this.client = client;
        this.user = user;
    }

    public Action(Long id, String actionName, Date dateDebutAction, String actionStatus, String actionDescription, Echeance echeance, Scenario scenario, Client client) {
        this.id = id;
        this.actionName = actionName;
        this.dateDebutAction = dateDebutAction;
        this.actionStatus = actionStatus;
        this.actionDescription = actionDescription;
        this.echeance = echeance;
        this.scenario = scenario;
        this.client = client;
    }
}

