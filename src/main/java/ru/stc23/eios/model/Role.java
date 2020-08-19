package ru.stc23.eios.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,STUDENT,TEACHER;

    @Override
    public String getAuthority() {
        return name();
    }
}
