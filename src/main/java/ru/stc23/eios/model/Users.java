package ru.stc23.eios.model;

public class Users {
    private long userId;
    private String login;
    private String password;
    private String email;
    private String FullName;
    private String UserSpec; // студент, преподаватель (преподаватель чего...)

    public Users(){}

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getUserSpec() {
        return UserSpec;
    }

    public void setUserSpec(String userSpec) {
        UserSpec = userSpec;
    }
}
