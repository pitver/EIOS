package ru.stc23.eios.model;

import java.util.Date;

public class ClassRole {
    private int roleId;
    private String roleName;
    private Date dateBeginRole;
    private Date dateEndRole;

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

    public Date getDateBeginRole() {
        return dateBeginRole;
    }

    public void setDateBeginRole(Date dateBeginRole) {
        this.dateBeginRole = dateBeginRole;
    }

    public Date getDateEndRole() {
        return dateEndRole;
    }

    public void setDateEndRole(Date dateEndRole) {
        this.dateEndRole = dateEndRole;
    }
}
