package backend.solutionRecouvrement.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Contact {
    private String type;
    private String value;
    private String Description;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Contact() {
    }

    public Contact(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public Contact(String type, String value, String description) {
        this.type = type;
        this.value = value;
        this.Description = description;
    }
}
