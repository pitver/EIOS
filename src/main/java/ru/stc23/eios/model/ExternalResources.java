package ru.stc23.eios.model;

import javax.persistence.*;

/**
 * ExternalResources
 *
 * @author Вершинин Пётр
 */
@Entity
@Table(name = "external_resourse")
public class ExternalResources {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String linkToRecourse;
    private String descriptions;
    private String preview;

    @ManyToOne(fetch = FetchType.EAGER)
    private Teacher username;


    public ExternalResources() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLinkToRecourse() {
        return linkToRecourse;
    }

    public void setLinkToRecourse(String linkToRecourse) {
        this.linkToRecourse = linkToRecourse;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(Teacher username) {
        this.username = username;
    }
}

