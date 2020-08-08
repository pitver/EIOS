package ru.stc23.eios.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,ADMIN,STUDENT,TEACHER;

    @Override
    public String getAuthority() {
        return name();
    }
}
