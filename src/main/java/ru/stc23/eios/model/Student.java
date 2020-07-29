package ru.stc23.eios.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



@Entity
@DiscriminatorValue("student")
public class Student extends User {


    public Student() {
    }
}
