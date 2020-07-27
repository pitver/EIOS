package ru.stc23.eios.model;

import org.hibernate.annotations.CollectionType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.lang.annotation.ElementType;
import java.util.Set;

@Entity
@DiscriminatorValue("Teacher")
public class Teacher extends User {

    @ElementCollection
    private Set<String> specification;

    public Teacher() {
    }

    public Set<String> getSpecification() {
        return specification;
    }

    public void setSpecification(Set<String> specification) {
        this.specification = specification;
    }
}
