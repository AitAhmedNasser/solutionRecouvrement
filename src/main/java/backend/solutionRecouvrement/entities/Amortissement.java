package backend.solutionRecouvrement.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(
        name = "amortissement"
)
public class Amortissement {
    @Id
    @Column(
            name = "ID_Tab"
    )
    private Long tableId;
    @Column(
            name = "ID_CLIENT"
    )
    private String obligoreId;
    private String tableNom;
    @OneToMany(
            mappedBy = "amortissement",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    private List<Echeance> echeanceList;

    public Long getTableId() {
        return this.tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public String getObligoreId() {
        return this.obligoreId;
    }

    public void setObligoreId(String obligoreId) {
        this.obligoreId = obligoreId;
    }

    public String getTableNom() {
        return this.tableNom;
    }

    public void setTableNom(String tableNom) {
        this.tableNom = tableNom;
    }

    public List<Echeance> getEcheanceList() {
        return this.echeanceList;
    }

    public void setEcheanceList(List<Echeance> echeanceList) {
        this.echeanceList = echeanceList;
    }

    public Amortissement() {
    }
}