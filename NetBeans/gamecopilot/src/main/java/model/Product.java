package model;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Product extends model.Entity {

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(columnDefinition = "text", nullable = false)
    private String description;
    @Column(nullable = false)
    private Integer quantity;
    
    @ManyToMany(mappedBy = "products")
    private List<OrderList>orders;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<OrderList> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderList> orders) {
        this.orders = orders;
    }
    
    
}
