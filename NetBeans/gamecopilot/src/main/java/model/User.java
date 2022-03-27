package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

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

    @OneToMany(mappedBy = "user")
    private List<OrderList> orders;
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? email : email.trim();
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
        this.name = name == null ? name : name.trim();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname ==null ? surname : surname.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    public List<OrderList> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderList> orders) {
        this.orders = orders;
    }

    
}
