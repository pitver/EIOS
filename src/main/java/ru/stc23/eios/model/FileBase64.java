package ru.stc23.eios.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "files")
public class FileBase64 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String filename;

    private String filetype;

    @Column(name = "filecode", columnDefinition = "LONGTEXT")
    private String filecode;

    public FileBase64(){    }

    public FileBase64(String filename, String filetype, String filecode){
        this.filename = filename;
        this.filetype = filetype;
        this.filecode = filecode;
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


    @OneToOne (optional = true)
    @JoinColumn(name="id", unique = false, nullable = false, updatable = false)
    private Work work;

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }
    //    @OneToOne(optional = true)
//    @JoinColumn(name="login", unique = false, nullable = false, updatable = false)
//    private User user;

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileBase64 that = (FileBase64) o;
        return Objects.equals(id, that.id) &&
                filename.equals(that.filename) &&
                Objects.equals(filetype, that.filetype) &&
                filecode.equals(that.filecode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, filename, filetype, filecode);
    }
}
