package backend.solutionRecouvrement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(
        name = "echeance"
)
public class Echeance {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            name = "ID_CLIENT"
    )
    private String obligoreId;
    @Column(
            name = "REF_ECHEANCE"
    )
    private String refEcheance;
    @Column(
            name = "status"
    )
    private String status;
    @Column(
            nullable = true,
            name = "FACILITY_ID"
    )
    private Boolean facilityId;
    @Column(
            name = "NUMERO_DOSSIER"
    )
    private String folderNumber;
    @Column(
            name = "CLASS_CREANCE"
    )
    private String creanceClass;
    @Column(
            name = "DATE_ECHEANCE"
    )
    private Date dateEcheance;
    @ManyToOne
    @JoinColumn(
            name = "tableId",
            foreignKey = @ForeignKey(
                    name = "FK_ID_Tab"
            ),
            referencedColumnName = "ID_Tab",
            nullable = false
    )
    @JsonBackReference
    private Amortissement amortissement;
    @OneToMany(
            mappedBy = "echeance"
    )
    @JsonIgnore
    private List<Action> listActions = new ArrayList();

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObligoreId() {
        return this.obligoreId;
    }

    public void setObligoreId(String obligoreId) {
        this.obligoreId = obligoreId;
    }

    public String getRefEcheance() {
        return this.refEcheance;
    }

    public void setRefEcheance(String refEcheance) {
        this.refEcheance = refEcheance;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getFacilityId() {
        return this.facilityId;
    }

    public void setFacilityId(Boolean facilityId) {
        this.facilityId = facilityId;
    }

    public String getFolderNumber() {
        return this.folderNumber;
    }

    public void setFolderNumber(String folderNumber) {
        this.folderNumber = folderNumber;
    }

    public String getCreanceClass() {
        return this.creanceClass;
    }

    public void setCreanceClass(String creanceClass) {
        this.creanceClass = creanceClass;
    }

    public Date getDateEcheance() {
        return this.dateEcheance;
    }

    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public Amortissement getAmortissement() {
        return this.amortissement;
    }

    public void setAmortissement(Amortissement amortissement) {
        this.amortissement = amortissement;
    }

    public Echeance() {
    }

    public List<Action> getListActions() {
        return this.listActions;
    }

    public void setListActions(List<Action> listActions) {
        this.listActions = listActions;
    }

    public Echeance(Long id, String obligoreId, String refEcheance, String status, Boolean facilityId, String folderNumber, String creanceClass, Date dateEcheance, Amortissement amortissement) {
        this.id = id;
        this.obligoreId = obligoreId;
        this.refEcheance = refEcheance;
        this.status = status;
        this.facilityId = facilityId;
        this.folderNumber = folderNumber;
        this.creanceClass = creanceClass;
        this.dateEcheance = dateEcheance;
        this.amortissement = amortissement;
    }
}