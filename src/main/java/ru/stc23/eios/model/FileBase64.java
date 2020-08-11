package ru.stc23.eios.model;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class FileBase64 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "filename")
    private String filename;

    @Column(name = "filecode")
    private String filecode;

    public FileBase64(){
    }

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

    @OneToOne(optional = false)
    @JoinColumn(name="username", unique = false, nullable = false, updatable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setBook(User user) {
        this.user = user;
    }

}
