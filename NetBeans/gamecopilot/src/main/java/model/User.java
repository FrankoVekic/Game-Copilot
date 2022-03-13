package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User extends model.Entity {

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String email;
    @Column(columnDefinition = "char(60)", nullable = false)
    private String password;
    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String name;
    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String surname;
    @Column(nullable = false)
    private String role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
