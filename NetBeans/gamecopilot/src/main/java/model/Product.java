package model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;

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

    
}
