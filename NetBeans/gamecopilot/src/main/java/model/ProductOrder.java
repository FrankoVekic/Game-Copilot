package model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ProductOrder extends model.Entity {

    @ManyToOne
    private OrderList orders;
    @ManyToOne
    private Product product;
    private Integer quantity;

    public OrderList getOrders() {
        return orders;
    }

    public void setOrders(OrderList orders) {
        this.orders = orders;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
