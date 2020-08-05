package ru.stc23.eios.model;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class FileBase64 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String filename;
    private String filecode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilecode() {
        return filecode;
    }

    public void setFilecode(String filecode) {
        this.filecode = filecode;
    }
}