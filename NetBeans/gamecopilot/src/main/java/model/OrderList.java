package model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "orders")
public class OrderList extends model.Entity {

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String address;
    @Column(columnDefinition = "varchar(35)", nullable = false)
    private String city;
    @Column(columnDefinition = "varchar(35)", nullable = false)
    private String country;
    @Column(nullable = false)
    private Date orderDate;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "orders")
    private List<ProductOrder> products;
   

    public List<ProductOrder> getProducts() {
        return products;
    }

    public void setProducts(List<ProductOrder> products) {
        this.products = products;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
}
