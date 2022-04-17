/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Comparator;
import model.OrderList;
import model.Product;

/**
 *
 * @author frank
 */
public class OrderComparator implements Comparator<OrderList> {

    @Override
    public int compare(OrderList o1, OrderList o2) {
        Integer first = o1.getProducts() == null ? 0 : o1.getProducts().size();
        Integer secound = o2.getProducts() == null ? 0 : o2.getProducts().size();
        return secound.compareTo(first);

    }

}
