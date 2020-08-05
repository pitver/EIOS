package ru.stc23.eios.model;

import javax.persistence.*;

@Entity
@Table(name = "usr")
public class FileBase64 implements  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;//login
    private String password;

}