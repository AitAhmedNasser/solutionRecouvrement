package backend.solutionRecouvrement.entities;


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
import java.time.LocalDate;

@Entity
@Table(
        name = "compte"
)
public class Compte {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            name = "NUMERO_COMPTE"
    )
    private String accountNumber;
    @Column(
            name = "DATE_OUVERTURE"
    )
    private LocalDate openDate;
    @Column(
            name = "ISO_CUR_CODE"
    )
    private String isoCurCode;
    @Column(
            name = "STATUS_COMPTE"
    )
    private String accountStatus;
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

    public Compte() {
    }

    public Compte(Long id, String accountNumber, LocalDate openDate, String isoCurCode, String accountStatus, Client client) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.openDate = openDate;
        this.isoCurCode = isoCurCode;
        this.accountStatus = accountStatus;
        this.client = client;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDate getOpenDate() {
        return this.openDate;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }

    public String getIsoCurCode() {
        return this.isoCurCode;
    }

    public void setIsoCurCode(String isoCurCode) {
        this.isoCurCode = isoCurCode;
    }

    public String getAccountStatus() {
        return this.accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
