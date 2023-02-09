package backend.solutionRecouvrement.auth.entities;

import jakarta.persistence.Table;
import java.util.Map;

@Table(name = "Mail")
public class Mail {
    private String from;
    private String to;
    private String subject;
    private String content;
    private Map<String, Object> model;

    public Mail() {
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, Object> getModel() {
        return this.model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }

    public Mail(String from, String to, String subject, String content, Map<String, Object> model) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
        this.model = model;
    }
}
