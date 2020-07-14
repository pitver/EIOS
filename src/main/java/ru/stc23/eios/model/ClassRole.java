package ru.stc23.eios.model;

import java.time.LocalDate;

public class ClassRole {
    private int roleId;
    private String roleName;
    private LocalDate dateBeginRole;
    private LocalDate dateEndRole;

    public ClassRole() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public LocalDate getDateBeginRole() {
        return dateBeginRole;
    }

    public void setDateBeginRole(LocalDate dateBeginRole) {
        this.dateBeginRole = dateBeginRole;
    }

    public LocalDate getDateEndRole() {
        return dateEndRole;
    }

    public void setDateEndRole(LocalDate dateEndRole) {
        this.dateEndRole = dateEndRole;
    }
}
