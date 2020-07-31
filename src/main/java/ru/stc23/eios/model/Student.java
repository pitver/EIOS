package ru.stc23.eios.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.Collections;
import java.util.Set;


@Entity
@DiscriminatorValue("student")
public class Student extends User {

    @ElementCollection
    private Set<String> studentGroup;

    public Student() {
    }

    public Set<String> getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(Set<String> studentGroup) {
        this.studentGroup = studentGroup;
    }
}
