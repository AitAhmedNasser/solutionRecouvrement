package backend.solutionRecouvrement.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(
        name = "client"
)
@IdClass(ClientId.class)
public class Client implements Serializable {
    @Id
    @Column(
            name = "ID_CLIENT"
    )
    private Long obligoreId;
    @Column(
            name = "reportingDate"
    )
    private Date reportingDate;
    @Column(
            name = "NOM_CLIENT"
    )
    private String obligoreName;
    @Column(
            name = "TYPE_CLIENT"
    )
    private String customerType;
    @Column(
            name = "entitieCode"
    )
    private Integer entitieCode;
    @Column(
            name = "borrowerType"
    )
    private String borrowerType;
    @Column(
            name = "ID_GROUPE"
    )
    private String groupId;
    @Column(
            name = "NOM_GROUPE"
    )
    private String groupName;
    @Column(
            name = "ID_AGENCE"
    )
    private String solId;
    @Column(
            name = "NOM_AGENCE"
    )
    private String solDescription;
    @Column(
            name = "CLASS_PRINCIPALE_CLIENT"
    )
    private String defaultFlagMain;
    @Column(
            name = "SOUS_CLASS_CLIENT"
    )
    private String defaultFlagSub;
    @Column(
            name = "DESC_SOUS_CLASS_CLIENT"
    )
    private String defaultFlageDesc;
    @Column(
            name = "CODE_WILAYA"
    )
    private String wilayaCode;
    @Column(
            name = "DESC_WILAYA"
    )
    private String wilayaCodeDescription;
    @Column(
            name = "CODE_SECTEUR"
    )
    private String industryCode;
    @Column(
            name = "SOLDE_BALANCE"
    )
    private Double soldeBalance;
    @Column(
            name = "DESC_SECTEUR"
    )
    private String industryCodeDesc;
    @Column(
            name = "CODE_SOUS_SECTEUR"
    )
    private String subsectorCode;
    @Column(
            name = "DESC_SOUS_SECTEUR"
    )
    private String subsectorCodeDesc;
    @OneToMany(
            mappedBy = "client",
            cascade = {CascadeType.ALL}
    )
    private List<Credit> listCredits;
    @OneToMany(
            mappedBy = "client",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    private List<Compte> listCompte;
    @ManyToOne
    @JoinColumn(
            name = "scenario_id",
            foreignKey = @ForeignKey(
                    name = "FK_SCENARIO_ID"
            ),
            referencedColumnName = "ID_SCENARIO"
    )
    private Scenario scenario;
    @Embedded
    private List<Contact> contacts;

    public Long getObligoreId() {
        return this.obligoreId;
    }

    public void setObligoreId(Long obligoreId) {
        this.obligoreId = obligoreId;
    }

    public Date getReportingDate() {
        return this.reportingDate;
    }

    public void setReportingDate(Date reportingDate) {
        this.reportingDate = reportingDate;
    }

    public String getObligoreName() {
        return this.obligoreName;
    }

    public void setObligoreName(String obligoreName) {
        this.obligoreName = obligoreName;
    }

    public String getCustomerType() {
        return this.customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public Integer getEntitieCode() {
        return this.entitieCode;
    }

    public void setEntitieCode(Integer entitieCode) {
        this.entitieCode = entitieCode;
    }

    public String getBorrowerType() {
        return this.borrowerType;
    }

    public void setBorrowerType(String borrowerType) {
        this.borrowerType = borrowerType;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSolId() {
        return this.solId;
    }

    public Client(Long obligoreId, Date reportingDate, String obligoreName, String customerType, Integer entitieCode, String borrowerType, String groupId, String groupName, String solId, String solDescription, String defaultFlagMain, String defaultFlagSub, String defaultFlageDesc, String wilayaCode, String wilayaCodeDescription, String industryCode, Double soldeBalance, String industryCodeDesc, String subsectorCode, String subsectorCodeDesc, Scenario scenario, List<Credit> listCredits, List<Compte> listCompte) {
        this.obligoreId = obligoreId;
        this.reportingDate = reportingDate;
        this.obligoreName = obligoreName;
        this.customerType = customerType;
        this.entitieCode = entitieCode;
        this.borrowerType = borrowerType;
        this.groupId = groupId;
        this.groupName = groupName;
        this.solId = solId;
        this.solDescription = solDescription;
        this.defaultFlagMain = defaultFlagMain;
        this.defaultFlagSub = defaultFlagSub;
        this.defaultFlageDesc = defaultFlageDesc;
        this.wilayaCode = wilayaCode;
        this.wilayaCodeDescription = wilayaCodeDescription;
        this.industryCode = industryCode;
        this.soldeBalance = soldeBalance;
        this.industryCodeDesc = industryCodeDesc;
        this.subsectorCode = subsectorCode;
        this.subsectorCodeDesc = subsectorCodeDesc;
        this.scenario = scenario;
        this.listCredits = listCredits;
        this.listCompte = listCompte;
    }

    public void setSolId(String solId) {
        this.solId = solId;
    }

    public String getSolDescription() {
        return this.solDescription;
    }

    public void setSolDescription(String solDescription) {
        this.solDescription = solDescription;
    }

    public String getDefaultFlagMain() {
        return this.defaultFlagMain;
    }

    public void setDefaultFlagMain(String defaultFlagMain) {
        this.defaultFlagMain = defaultFlagMain;
    }

    public String getDefaultFlagSub() {
        return this.defaultFlagSub;
    }

    public void setDefaultFlagSub(String defaultFlagSub) {
        this.defaultFlagSub = defaultFlagSub;
    }

    public String getDefaultFlageDesc() {
        return this.defaultFlageDesc;
    }

    public void setDefaultFlageDesc(String defaultFlageDesc) {
        this.defaultFlageDesc = defaultFlageDesc;
    }

    public String getWilayaCode() {
        return this.wilayaCode;
    }

    public void setWilayaCode(String wilayaCode) {
        this.wilayaCode = wilayaCode;
    }

    public String getWilayaCodeDescription() {
        return this.wilayaCodeDescription;
    }

    public void setWilayaCodeDescription(String wilayaCodeDescription) {
        this.wilayaCodeDescription = wilayaCodeDescription;
    }

    public String getIndustryCode() {
        return this.industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public Double getSoldeBalance() {
        return this.soldeBalance;
    }

    public void setSoldeBalance(Double soldeBalance) {
        this.soldeBalance = soldeBalance;
    }

    public String getIndustryCodeDesc() {
        return this.industryCodeDesc;
    }

    public void setIndustryCodeDesc(String industryCodeDesc) {
        this.industryCodeDesc = industryCodeDesc;
    }

    public String getSubsectorCode() {
        return this.subsectorCode;
    }

    public void setSubsectorCode(String subsectorCode) {
        this.subsectorCode = subsectorCode;
    }

    public String getSubsectorCodeDesc() {
        return this.subsectorCodeDesc;
    }

    public void setSubsectorCodeDesc(String subsectorCodeDesc) {
        this.subsectorCodeDesc = subsectorCodeDesc;
    }

    public List<Credit> getListCredits() {
        return this.listCredits;
    }

    public void setListCredits(List<Credit> listCredits) {
        this.listCredits = listCredits;
    }

    public List<Compte> getListCompte() {
        return this.listCompte;
    }

    public void setListCompte(List<Compte> listCompte) {
        this.listCompte = listCompte;
    }

    public Client(Long obligoreId, Date reportingDate, String obligoreName, String customerType, Integer entitieCode, String borrowerType, String groupId, String groupName, String solId, String solDescription, String defaultFlagMain, String defaultFlagSub, String defaultFlageDesc, String wilayaCode, String wilayaCodeDescription, String industryCode, Double soldeBalance, String industryCodeDesc, String subsectorCode, String subsectorCodeDesc, List<Credit> listCredits, List<Compte> listCompte) {
        this.obligoreId = obligoreId;
        this.reportingDate = reportingDate;
        this.obligoreName = obligoreName;
        this.customerType = customerType;
        this.entitieCode = entitieCode;
        this.borrowerType = borrowerType;
        this.groupId = groupId;
        this.groupName = groupName;
        this.solId = solId;
        this.solDescription = solDescription;
        this.defaultFlagMain = defaultFlagMain;
        this.defaultFlagSub = defaultFlagSub;
        this.defaultFlageDesc = defaultFlageDesc;
        this.wilayaCode = wilayaCode;
        this.wilayaCodeDescription = wilayaCodeDescription;
        this.industryCode = industryCode;
        this.soldeBalance = soldeBalance;
        this.industryCodeDesc = industryCodeDesc;
        this.subsectorCode = subsectorCode;
        this.subsectorCodeDesc = subsectorCodeDesc;
        this.listCredits = listCredits;
        this.listCompte = listCompte;
    }

    public Client() {
    }

    public Scenario getScenario() {
        return this.scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public Client(Long obligoreId, Date reportingDate, String obligoreName, String customerType, Integer entitieCode, String borrowerType, String groupId, String groupName, String solId, String solDescription, String defaultFlagMain, String defaultFlagSub, String defaultFlageDesc, String wilayaCode, String wilayaCodeDescription, String industryCode, Double soldeBalance, String industryCodeDesc, String subsectorCode, String subsectorCodeDesc, List<Credit> listCredits, List<Compte> listCompte, Scenario scenario) {
        this.obligoreId = obligoreId;
        this.reportingDate = reportingDate;
        this.obligoreName = obligoreName;
        this.customerType = customerType;
        this.entitieCode = entitieCode;
        this.borrowerType = borrowerType;
        this.groupId = groupId;
        this.groupName = groupName;
        this.solId = solId;
        this.solDescription = solDescription;
        this.defaultFlagMain = defaultFlagMain;
        this.defaultFlagSub = defaultFlagSub;
        this.defaultFlageDesc = defaultFlageDesc;
        this.wilayaCode = wilayaCode;
        this.wilayaCodeDescription = wilayaCodeDescription;
        this.industryCode = industryCode;
        this.soldeBalance = soldeBalance;
        this.industryCodeDesc = industryCodeDesc;
        this.subsectorCode = subsectorCode;
        this.subsectorCodeDesc = subsectorCodeDesc;
        this.listCredits = listCredits;
        this.listCompte = listCompte;
        this.scenario = scenario;
    }

    public List<Contact> getContacts() {
        return this.contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public Client(Long obligoreId, Date reportingDate, String obligoreName, String customerType, Integer entitieCode, String borrowerType, String groupId, String groupName, String solId, String solDescription, String defaultFlagMain, String defaultFlagSub, String defaultFlageDesc, String wilayaCode, String wilayaCodeDescription, String industryCode, Double soldeBalance, String industryCodeDesc, String subsectorCode, String subsectorCodeDesc, List<Credit> listCredits, List<Compte> listCompte, Scenario scenario, List<Contact> contacts) {
        this.obligoreId = obligoreId;
        this.reportingDate = reportingDate;
        this.obligoreName = obligoreName;
        this.customerType = customerType;
        this.entitieCode = entitieCode;
        this.borrowerType = borrowerType;
        this.groupId = groupId;
        this.groupName = groupName;
        this.solId = solId;
        this.solDescription = solDescription;
        this.defaultFlagMain = defaultFlagMain;
        this.defaultFlagSub = defaultFlagSub;
        this.defaultFlageDesc = defaultFlageDesc;
        this.wilayaCode = wilayaCode;
        this.wilayaCodeDescription = wilayaCodeDescription;
        this.industryCode = industryCode;
        this.soldeBalance = soldeBalance;
        this.industryCodeDesc = industryCodeDesc;
        this.subsectorCode = subsectorCode;
        this.subsectorCodeDesc = subsectorCodeDesc;
        this.listCredits = listCredits;
        this.listCompte = listCompte;
        this.scenario = scenario;
        this.contacts = contacts;
    }
}
