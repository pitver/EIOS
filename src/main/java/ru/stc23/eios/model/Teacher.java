package ru.stc23.eios.model;

import java.util.Set;

public class Teacher extends User {
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
