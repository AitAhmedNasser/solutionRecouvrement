package backend.solutionRecouvrement.entities;


import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ClientId implements Serializable {
    private Long obligoreId;
    private String reportingDate;

    public ClientId() {
    }

    public void setObligoreId(Long obligoreId) {
        this.obligoreId = obligoreId;
    }

    public void setReportingDate(String reportingDate) {
        this.reportingDate = reportingDate;
    }

    public Long getObligoreId() {
        return this.obligoreId;
    }

    public String getReportingDate() {
        return this.reportingDate;
    }

    public ClientId(Long obligoreId, String reportingDate) {
        this.obligoreId = obligoreId;
        this.reportingDate = reportingDate;
    }
}
